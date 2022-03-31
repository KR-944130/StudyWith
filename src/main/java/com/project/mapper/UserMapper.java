package com.project.mapper;

import org.apache.ibatis.annotations.Param;

import com.project.domain.Member;

public interface UserMapper {
	
	int insert(Member member);
	
//	userEmail로 사용자 삭제
	int delete(String userEmail);
	
//	pk(USER_EMAIL) 중복 체크
//	uk(NICKNAME) 중복 체크
//	uk(USER_PHONE) 중복 체크
	int checkDuplication(@Param("data") String data, @Param("condition") String condition);
}
