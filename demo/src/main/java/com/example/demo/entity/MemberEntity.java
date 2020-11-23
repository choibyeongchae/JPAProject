package com.example.demo.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="member")
@Builder
public class MemberEntity{

	@Id
	private Integer mbrno;
	
	@Column
	private String mbrNm;
	
	@Column
	private String email;
	
	@Column
	private String password;
	
	@Column
	private String phone;
	
	@Column
	private String birth;
	
	@Column
	private String mbrGrade;
	
	@Column
	private Integer mbrPoint;
	
	@Column
	private String address;
	
	@Column
	private Date regDate;
	
	@Column
	private Date updDate;
	
	@Builder
	public MemberEntity(Integer mbrno, String mbrNm, String email, String password, String phone, String birth, String mbrGrade,
			Integer mbrPoint, String address, String userRole) {
		this.mbrno = mbrno;
		this.mbrNm = mbrNm;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.birth = birth;
		this.mbrGrade = mbrGrade;
		this.mbrPoint = mbrPoint;
		this.address = address;
	}

}
