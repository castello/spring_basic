import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
        public static void main(String[] args) throws Exception {
            ServerSocket serverSocket = new ServerSocket(8888);

            System.out.println("서버가 요청을 받을 준비가 되었습니다.");
            System.out.println("연결을 기다리는 중...");
            Socket socket = serverSocket.accept();
            System.out.println("연결되었습니다.");
            InputStream in = socket.getInputStream();

            byte[] byteArr = new byte[8192];

            in.read(byteArr);
            String request = new String(byteArr, "utf-8");
            System.out.println("request="+request);
            String[] lines = request.split("\n");
            System.out.println("line cnt="+lines.length);
            for (int i = 0; i < lines.length; i++)
                System.out.printf("[%d]%s%n", i+1, lines[i] );

//            GET /ch2/getYoil HTTP/1.1
            System.out.println(lines[0]);
            System.out.println(lines[0].split(" ")[1]);// /ch2/getYoil

        }
    }

/*
line cnt=19
[1]GET /ch2/getYoil HTTP/1.1
[2]Host: localhost:8888
[3]Connection: keep-alive
[4]Cache-Control: max-age=0
[5]sec-ch-ua: "Chromium";v="94", "Google Chrome";v="94", ";Not A Brand";v="99"
[6]sec-ch-ua-mobile: ?0
[7]sec-ch-ua-platform: "macOS"
[8]Upgrade-Insecure-Requests: 1
[9]User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.61 Safari/537.36
[10]Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9
[11]Sec-Fetch-Site: none
[12]Sec-Fetch-Mode: navigate
[13]Sec-Fetch-User: ?1
[14]Sec-Fetch-Dest: document
[15]Accept-Encoding: gzip, deflate, br
[16]Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7
[17]Cookie: Idea-3de0fd5c=dad034bc-87c4-40bb-b985-434ddba1a83d
[18]
[19]
GET /ch2/getYoil HTTP/1.1
/ch2/getYoil

*/
