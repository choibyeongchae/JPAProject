package com.example.demo.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.MemberEntity;
import com.example.demo.entity.QMemberEntity;
import com.example.demo.repository.MemberRepository;
import com.example.util.SHA256Util;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	MemberRepository memberRepository;

	@Autowired
	JPAQueryFactory queryFactory;
	
	@Override
	public MemberEntity memberJoin(HashMap map) throws Exception {
		QMemberEntity member = QMemberEntity.memberEntity;
		Integer mbrno = queryFactory.select(member.mbrno.max().coalesce(0)).from(member).fetchOne();
		
		if (mbrno == null || mbrno == 0) {
			mbrno = 1;
		} else {
			mbrno += 1;
		}
		
		String getPw = String.valueOf(map.get("password"));
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(getPw.getBytes());
		String password = String.format("%064x", new BigInteger(1, md.digest()));
		
		/* builder setting*/
		MemberEntity e = MemberEntity.builder()
				.mbrno(mbrno)
				.mbrNm(String.valueOf(map.get("name")))
				.email(String.valueOf(map.get("email")))
				.password(password)
				.phone(String.valueOf(map.get("phone")).replaceAll("-", ""))
				.birth(String.valueOf(map.get("birth")))
				.address(String.valueOf(map.get("address")))
				.mbrGrade(String.valueOf("normal"))
				.mbrPoint(0)
				.build();
		
		// save
		MemberEntity result  = memberRepository.save(e);
		
		return result;
	}

	@Override
	public Integer memberCheck(String userId) throws Exception {
		//JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
		QMemberEntity member = QMemberEntity.memberEntity;
		Integer mbrCnt = (int) queryFactory.select(member.mbrno.count()).from(member).where(member.email.eq(userId)).fetchCount();
		return mbrCnt;
	}

	@Override
	public String checkUserInfo(HashMap map) throws Exception {
		
		Optional<MemberEntity> memberInfo = memberRepository.findByEmail(String.valueOf(map.get("email")));
		
		String result = "";
		String getPw = String.valueOf(map.get("password"));
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(getPw.getBytes());
		String password = String.format("%064x", new BigInteger(1, md.digest()));
		if (memberInfo.get().getPassword().equals(password)) {
			result = "true";
		} else {
			result = "false";
		}
		return result;
	}
	
}
