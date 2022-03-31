package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.domain.Member;
import com.project.service.UserService;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/users/*")
@Log4j
public class UserController {
	
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
//	이용약관 페이지 이동
	@GetMapping("terms")
	public String temrs() {
		return "user/terms";
	}
	
//	회원가입 페이지 이동
	@GetMapping("join")
	public String joinForm(String agree) {
		if(agree == null) {
			return "redirect:/users/terms";
		}
		return "user/join";
	}
	
//	회원가입
	@PostMapping("join")
	public String join(Member member) {
		String userPhone = member.getUserPhone1() + member.getUserPhone2() + member.getUserPhone3();
//		핸드폰 번호를 연결해서 userPhone 생성
		member.setUserPhone(userPhone);
		try {
			userService.join(member);
		}
//		발생할 수 있는 중복 예외를 처리해준다. (이메일 중복, 닉네임 중복, 핸드폰 번호 중복)
		catch (IllegalStateException e) {
			log.info(e.getMessage());
			return "redirect:/users/join?agree=true";
		}
//		회원가입 성공
		return "redirect:/";
	}
}
