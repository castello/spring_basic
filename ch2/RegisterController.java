package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller // ctrl+shift+o 자동 임포트 
public class RegisterController {
//	@RequestMapping(value="/register/add", method=RequestMethod.GET) // 신규회원 가입
//	@RequestMapping("/register/add") // 신규회원 입력
	@GetMapping("/register/add") // 4.3부터 추가
	public String register() {
		return "registerForm";  // WEB-INF/views/registerForm.jsp
	}
	
//	@RequestMapping(value="/register/save", method=RequestMethod.POST) // 신규회원 가입
	@PostMapping("/register/save")
	public String save(@ModelAttribute("user") User user, RedirectAttributes rttr) {
		if(!isValid(user)) {
			String msg = "id를 잘못입력하셨습니다.";
			
			rttr.addFlashAttribute("msg", msg);
			return "redirect:/register/add"; // 신규회원 가입화면으로 이동(redirect)
		}
		
		return "registerInfo";
	}

	private boolean isValid(User user) {
		return false;
	}
	
}
