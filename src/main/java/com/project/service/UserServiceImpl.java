package com.project.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.domain.Member;
import com.project.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	
	private final UserMapper userMapper;
	
	@Autowired
	public UserServiceImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
//	회원가입
	@Override
	public boolean join(Member newMember) {
		if(userMapper.checkDuplication(newMember.getUserEmail(), "email") == 1) {
			throw new IllegalStateException("중복된 아이디입니다.");
		}
		if(userMapper.checkDuplication(newMember.getNickname(), "nickname") == 1) {
			throw new IllegalStateException("중복된 닉네임입니다.");
		}
		if(userMapper.checkDuplication(newMember.getUserPhone(), "phone") == 1) {
			throw new IllegalStateException("중복된 핸드폰 번호입니다.");
		}
		return userMapper.insert(newMember) == 1;
	}
	
//	회원탈퇴
	@Override
	public boolean quit(String userEmail) {
		return userMapper.delete(userEmail) == 1;
	}
}
