package com.example.demo.service;

import java.util.HashMap;

import com.example.demo.entity.MemberEntity;

public interface MemberService {

	public MemberEntity memberJoin(HashMap map) throws Exception;
	
	public Integer memberCheck(String userId) throws Exception;
	
	public String checkUserInfo(HashMap map) throws Exception;
}
