package com.project.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.project.domain.Member;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class UserServiceTest {
	@Setter(onMethod_ = @Autowired)
	private UserService userService;
	
//	UserService 주입 테스트
	@Test
	public void serviceTest() {
		log.info(userService);
	}
	
//	회원가입 테스트
	@Test
	public void joinTest() {
		Member member = new Member();
		member.setUserEmail("test@naver.com");
		member.setUserPw("1234");
		member.setNickname("닉네임");
		member.setUserName("이름");
		member.setUserPhone("010-1234-5678");
		member.setUserBirth("2022-01-01");
		member.setUserGender("남");
		member.setPostCode(12345);
		member.setAddress("어디시 어디구 어디로");
		member.setDetailAddress("몇동 몇호");
		member.setExtraAddress("etc");
		userService.join(member);
		userService.quit(member.getUserEmail());
	}
	
//	중복아이디로 회원가입 테스트
	@Test
	public void DuplicationEmailTest() {
		Member member1 = new Member();
		
		member1.setUserEmail("test@naver.com");
		member1.setUserPw("1234");
		member1.setNickname("닉네임");
		member1.setUserName("이름");
		member1.setUserPhone("010-1234-5678");
		member1.setUserBirth("2022-01-01");
		member1.setUserGender("남");
		member1.setPostCode(12345);
		member1.setAddress("어디시 어디구 어디로");
		member1.setDetailAddress("몇동 몇호");
		member1.setExtraAddress("etc");
		
		userService.join(member1);
		
		Member member2 = new Member();
		
		member2.setUserEmail("test@naver.com");
		member2.setUserPw("1234");
		member2.setNickname("닉네임");
		member2.setUserName("이름");
		member2.setUserPhone("010-1234-5678");
		member2.setUserBirth("2022-01-01");
		member2.setUserGender("남");
		member2.setPostCode(12345);
		member2.setAddress("어디시 어디구 어디로");
		member2.setDetailAddress("몇동 몇호");
		member2.setExtraAddress("etc");
		
		try {
			userService.join(member2);
		} catch (IllegalStateException e) {
			assertEquals("중복된 아이디입니다.", e.getMessage());
			userService.quit(member1.getUserEmail());
		}
	}
//	중복닉네임으로 회원가입 테스트
	@Test
	public void DuplicationNickNameTest() {
		Member member1 = new Member();
		
		member1.setUserEmail("test1@naver.com");
		member1.setUserPw("1234");
		member1.setNickname("닉네임");
		member1.setUserName("이름");
		member1.setUserPhone("010-1234-5678");
		member1.setUserBirth("2022-01-01");
		member1.setUserGender("남");
		member1.setPostCode(12345);
		member1.setAddress("어디시 어디구 어디로");
		member1.setDetailAddress("몇동 몇호");
		member1.setExtraAddress("etc");
		
		userService.join(member1);
		
		Member member2 = new Member();
		
		member2.setUserEmail("test2@naver.com");
		member2.setUserPw("1234");
		member2.setNickname("닉네임");
		member2.setUserName("이름");
		member2.setUserPhone("010-1234-5678");
		member2.setUserBirth("2022-01-01");
		member2.setUserGender("남");
		member2.setPostCode(12345);
		member2.setAddress("어디시 어디구 어디로");
		member2.setDetailAddress("몇동 몇호");
		member2.setExtraAddress("etc");
		
		try {
			userService.join(member2);
		} catch (IllegalStateException e) {
			assertEquals("중복된 닉네임입니다.", e.getMessage());
			userService.quit(member1.getUserEmail());
			userService.quit(member2.getUserEmail());
		}
	}
//	중복 핸드폰 번호로 회원가입 테스트
	@Test
	public void DuplicationPhoneTest() {
		Member member1 = new Member();
		
		member1.setUserEmail("test1@naver.com");
		member1.setUserPw("1234");
		member1.setNickname("닉네임1");
		member1.setUserName("이름");
		member1.setUserPhone("010-1234-5678");
		member1.setUserBirth("2022-01-01");
		member1.setUserGender("남");
		member1.setPostCode(12345);
		member1.setAddress("어디시 어디구 어디로");
		member1.setDetailAddress("몇동 몇호");
		member1.setExtraAddress("etc");
		
		userService.join(member1);
		
		Member member2 = new Member();
		
		member2.setUserEmail("test2@naver.com");
		member2.setUserPw("1234");
		member2.setNickname("닉네임2");
		member2.setUserName("이름");
		member2.setUserPhone("010-1234-5678");
		member2.setUserBirth("2022-01-01");
		member2.setUserGender("남");
		member2.setPostCode(12345);
		member2.setAddress("어디시 어디구 어디로");
		member2.setDetailAddress("몇동 몇호");
		member2.setExtraAddress("etc");
		
		try {
			userService.join(member2);
		} catch (IllegalStateException e) {
			assertEquals("중복된 핸드폰 번호입니다.", e.getMessage());
			userService.quit(member1.getUserEmail());
			userService.quit(member2.getUserEmail());
		}
	}
}
