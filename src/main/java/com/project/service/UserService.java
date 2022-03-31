package com.project.service;

import com.project.domain.Member;

public interface UserService {
	
	boolean join(Member newMember);
	boolean quit(String userEmail);
}
