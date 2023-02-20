package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class ExceptionController {
	@ExceptionHandler({NullPointerException.class, FileNotFoundException.class})
	public String catcher2(Exception ex, Model m) {
		m.addAttribute("ex", ex);
		return "error";
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // 200 -> 500
	public String catcher(Exception ex, Model m) {
		System.out.println("catcher() in ExceptionController");
		System.out.println("m="+m);
//		m.addAttribute("ex", ex);

		return "error";
	}
	
	@RequestMapping("/ex")
	public String main(Model m) throws Exception {
		m.addAttribute("msg", "message from ExceptionController.main()");
		throw new Exception("¿¹¿Ü°¡ ¹ß»ýÇß½À´Ï´Ù.");
	}

	@RequestMapping("/ex2")
	public String main2() throws Exception {
		throw new NullPointerException("¿¹¿Ü°¡ ¹ß»ýÇß½À´Ï´Ù.");
	}
}
