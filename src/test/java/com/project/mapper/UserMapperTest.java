package com.project.mapper;

import java.sql.SQLIntegrityConstraintViolationException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.project.domain.Member;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class UserMapperTest {
	
	@Setter(onMethod_ = @Autowired)
	private UserMapper userMapper;
	
//	mapper 주입 테스트
	@Test
	public void mapperTest() {
		log.info(userMapper);
	}
	
//	회원테이블 insert 테스트
	@Test
	public void insertTest() {
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
		userMapper.insert(member);
		userMapper.delete(member.getUserEmail());
	}
	
}
