package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns={"/hello"}, loadOnStartup=1)
	@WebServlet("/hello")
	public class HelloServlet extends HttpServlet {
		@Override
		public void init() throws ServletException {  
			// 서블릿 초기화 - 서블릿이 생성 또는 리로딩 때, 단 한번만 수행됨.
			System.out.println("[HelloSerlvet] init()");
		}
		   
		@Override // 호출될 때마다 반복적으로 수행됨.
		public void service(HttpServletRequest request, HttpServletResponse response) {
			// 1. 입력
			// 2. 처리 
			// 3. 출력
			System.out.println("[HelloSerlvet] service()");
		}
	
		@Override   
		public void destroy() {   
			// 뒷정리 작업 - 서블릿이 제거(unload)될 때, 단 한번만 수행됨.
			System.out.println("[HelloSerlvet] destroy()");  
		}
	}
	
	
	
