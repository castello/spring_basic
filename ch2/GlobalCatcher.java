package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

	@ControllerAdvice("com.fastcampus.ch3") // ÁöÁ¤µÈ ÆÐÅ°Áö¿¡¼­ ¹ß»ýÇÑ ¿¹¿Ü¸¸ Ã³¸®
//	@ControllerAdvice // ¸ðµç ÆÐÅ°Áö¿¡ Àû¿ë
	public class GlobalCatcher {
		@ExceptionHandler({NullPointerException.class, FileNotFoundException.class})
		public String catcher2(Exception ex, Model m) {
			m.addAttribute("ex", ex);
			return "error";
		}
	
		@ExceptionHandler(Exception.class)
		public String catcher(Exception ex, Model m) {
			m.addAttribute("ex", ex);
	
			return "error";
		}
	}
