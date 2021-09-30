package com.fastcampus.ch2;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequestMessage {
	@RequestMapping("/requestMessage")
	public void main(HttpServletRequest request) throws Exception {
		
		// 1. request line
		String requestLine = request.getMethod();       // GET 또는 POST
		requestLine += " " + request.getRequestURI();   // /ch2/requestMessage
		
		String queryString = request.getQueryString();  // year=2021&month=10&day=1
		requestLine += queryString == null ? "" : "?"+queryString;  
		requestLine += " " + request.getProtocol();     // HTTP/1.1
		System.out.println(requestLine);		

		
		// 2. request headers
		Enumeration<String> e = request.getHeaderNames();

		while (e.hasMoreElements()) {
			String name = e.nextElement();
			System.out.println(name + ":" + request.getHeader(name));
		}
		
		// 3. request body - POST일 때만 해당, GET은 body가 없음(CONTENT_LENGTH=0)
		final int CONTENT_LENGTH = request.getContentLength();
//		System.out.println("content length="+CONTENT_LENGTH);
		
		if(CONTENT_LENGTH > 0) {
			byte[] content = new byte[CONTENT_LENGTH];

			InputStream in = request.getInputStream();
			in.read(content, 0, CONTENT_LENGTH);
			
			System.out.println(); // empty line
			System.out.println(new String(content, "utf-8")); // year=2021&month=10&day=1
		}  // if
	} // main
}


[실행결과1] - GET 요청
GET /ch2/requestMessage?year=2021&month=10&day=1 HTTP/1.1  <--- 요청 라인(request line)
host:localhost:8080
connection:keep-alive
sec-ch-ua:"Chromium";v="94", "Google Chrome";v="94", ";Not A Brand";v="99"
sec-ch-ua-mobile:?0
sec-ch-ua-platform:"macOS"
upgrade-insecure-requests:1
user-agent:Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.61 Safari/537.36
accept:text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9
sec-fetch-site:none
sec-fetch-mode:navigate
sec-fetch-user:?1
sec-fetch-dest:document
accept-encoding:gzip, deflate, br
accept-language:ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7

[실행결과2] - POST 요청
POST /ch2/requestMessage HTTP/1.1  <--- 요청 라인(request line)
host:localhost:8080
connection:keep-alive
content-length:90
sec-ch-ua:"Chromium";v="94", "Google Chrome";v="94", ";Not A Brand";v="99"
cache-control:no-cache
content-type:application/x-www-form-urlencoded
sec-ch-ua-mobile:?0
user-agent:Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.61 Safari/537.36
sec-ch-ua-platform:"macOS"
accept:*/*
origin:chrome-extension://coohjcphdfgbiolnekdpbcijmhambjff
sec-fetch-site:none
sec-fetch-mode:cors
sec-fetch-dest:empty
accept-encoding:gzip, deflate, br
accept-language:ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7
                          <--- empty line
year=2021&month=10&day=1  <--- request body
