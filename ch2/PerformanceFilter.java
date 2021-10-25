package com.fastcampus.ch2;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns="/*")
public class PerformanceFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// 초기화 작업
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		long startTime = System.currentTimeMillis();
		
		chain.doFilter(request, response); // 서블릿 또는 다음 필더를 호출
		
		System.out.print("["+((HttpServletRequest)request).getRequestURI()+"]");
		System.out.println(" 소요시간="+(System.currentTimeMillis()-startTime)+"ms");
	}

	@Override
	public void destroy() {
		// 정리 작업
	}

}
