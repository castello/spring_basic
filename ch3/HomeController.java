package com.fastcampus.ch3;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.*;
import org.springframework.web.context.support.*;

import javax.servlet.*;
import javax.servlet.http.*;

@Controller
public class HomeController {
	@Autowired
	WebApplicationContext servletAC; // Servlet AC

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, HttpServletRequest request, Model model) {
		// 원래는 request.getServletContext()지만, 컨트롤러는 HttpServlet을 상속받지 않아서 아래와 같이 해야함.
		ServletContext sc = request.getSession().getServletContext(); // ApplicationContextFacade
		WebApplicationContext rootAC = WebApplicationContextUtils.getWebApplicationContext(sc); // Root AC

		System.out.println("webApplicationContext = " + rootAC);
		System.out.println("servletAC = " + servletAC);

		System.out.println("rootAC.getBeanDefinitionNames() = " + Arrays.toString(rootAC.getBeanDefinitionNames()));
		System.out.println("servletAC.getBeanDefinitionNames() = " + Arrays.toString(servletAC.getBeanDefinitionNames()));

		System.out.println("rootAC.getBeanDefinitionCount() = " + rootAC.getBeanDefinitionCount());
		System.out.println("servletAC.getBeanDefinitionCount() = " + servletAC.getBeanDefinitionCount());

		System.out.println("servletAC.getParent()==rootAC = " + (servletAC.getParent() == rootAC)); // servletAC.getParent()==rootAC = true
		return "home";
	}
}
/* [실행결과]
webApplicationContext = Root WebApplicationContext: startup date [Thu Jan 06 16:26:50 KST 2022]; root of context hierarchy
servletAC = WebApplicationContext for namespace 'appServlet-servlet': startup date [Thu Jan 06 16:26:51 KST 2022]; parent: Root WebApplicationContext
rootAC.getBeanDefinitionNames() = []
servletAC.getBeanDefinitionNames() = [mvcContentNegotiationManager, org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping, mvcCorsConfigurations, org.springframework.format.support.FormattingConversionServiceFactoryBean#0, org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter, mvcUriComponentsContributor, org.springframework.web.servlet.handler.MappedInterceptor#0, org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver#0, org.springframework.web.servlet.mvc.annotation.ResponseStatusExceptionResolver#0, org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver#0, org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping, org.springframework.web.servlet.mvc.HttpRequestHandlerAdapter, org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter, mvcHandlerMappingIntrospector, mvcResourceUrlProvider, org.springframework.web.servlet.handler.MappedInterceptor#1, mvcPathMatcher, mvcUrlPathHelper, org.springframework.web.servlet.resource.ResourceHttpRequestHandler#0, org.springframework.web.servlet.handler.SimpleUrlHandlerMapping#0, org.springframework.web.servlet.view.InternalResourceViewResolver#0, car, door, engine, homeController, superEngine, turboEngine, org.springframework.context.annotation.internalConfigurationAnnotationProcessor, org.springframework.context.annotation.internalAutowiredAnnotationProcessor, org.springframework.context.annotation.internalRequiredAnnotationProcessor, org.springframework.context.annotation.internalCommonAnnotationProcessor, org.springframework.context.event.internalEventListenerProcessor, org.springframework.context.event.internalEventListenerFactory]
rootAC.getBeanDefinitionCount() = 0
servletAC.getBeanDefinitionCount() = 33
servletAC.getParent()==rootAC = true
*/
