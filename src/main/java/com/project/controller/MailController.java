package com.project.controller;

import java.util.Map;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MailController {
	
	private final JavaMailSender mailSender;
	
	@Autowired
	public MailController(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	@PostMapping(value = "/authMail", consumes = "application/json")
	@ResponseBody
	public ResponseEntity<String> sendAuthMail(@RequestBody String userEmail, HttpServletResponse response) throws Exception {
		String subject = "StudyWith! 인증 번호";
		String authCode = generateAuthCode();
		String content = "<h3>다음 인증번호를 복사해서 사용하세요</h3>"
				+ "<span style=\"background-color: #7b9acc; color: #FCF6F5; font-size: 20px;\">" + authCode + "</span>";
		final MimeMessagePreparator preparator = new MimeMessagePreparator() {

			public void prepare(MimeMessage mimeMessage) throws Exception {
				final MimeMessageHelper mailHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

				mailHelper.setTo(userEmail.substring(10).replace("%40", "@"));
				mailHelper.setSubject(subject);
				mailHelper.setText(content, true);

			}

		};

		try {
			mailSender.send(preparator);
			Cookie cookie = new Cookie("authCode", authCode);
			cookie.setMaxAge(6 * 30);
			cookie.setPath("/");
			response.addCookie(cookie);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("cookie generate", HttpStatus.OK);
	}
	
	@PostMapping(value = "/authMail/codeCheck")
	@ResponseBody
	public ResponseEntity<String> authCodeCheck(@RequestBody String authCode, HttpServletRequest request, HttpServletResponse response) {
		authCode = authCode.substring("authCode=".length());
		Cookie[] cookies = request.getCookies();
		boolean flag = false;
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("authCode")) {
					if(authCode.equals(cookie.getValue())) {
						flag = true;
						Cookie target = new Cookie("authCode", null);
						target.setMaxAge(0);
						target.setPath("/");
						response.addCookie(target);
						break;
					}
				}
			}
		}
		if(flag) {
			return new ResponseEntity<String>("auth complete", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("auth fail", HttpStatus.OK);
		}
	}
	
	private String generateAuthCode() {
		
		String[] codeArr = {
				"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"
				, "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M"
				, "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
		};
		
		String result = "";
		int maxNum = codeArr.length;
		for (int i = 0; i < 6; i++) {
			
			result += codeArr[(int)(Math.random() * maxNum)];
		}
		
		return result;
	}
}
