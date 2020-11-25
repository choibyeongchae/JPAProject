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
@Table(name="product")
@Builder
public class Product {

	@Id
	private Integer prdno;
	
	@Column
	private String prdnm;
	
	@Column
	private Integer prdPrice;
	
	@Column
	private String prdDesc;
	
	@Column
	private Double prdAvg;
	
	@Column
	private Integer likeCnt;
	
	@Column
	private String cate;
	
	@Column
	private String giftYn;
	
	@Column
	private String dplfl;
	
	@Column
	private String newYn;
	
	@Column
	private Integer salqty;
	
	@Column
	private String salState;
	
	@Column
	private String prdImgnm;
	
	@Column
	private String prdImgurl;
	
	@Column
	private String prdType;
	
	@Column
	private Date regDate;
	
	@Column
	private Date updDate;
	
	@Builder
	public Product(Integer prdno, String prdnm, Integer prdPrice, String prdDesc, Double prdAvg,
			 Integer likeCnt, String cate, String giftYn, String dplfl, String newYn, Integer salqty,
			 String salState, String prdImgnm, String prdImgurl, String prdType) {
		this.prdno = prdno;
		this.prdnm = prdnm;
		this.prdPrice = prdPrice;
		this.prdDesc = prdDesc;
		this.prdAvg = prdAvg;
		this.likeCnt = likeCnt; 
		this.cate = cate;
		this.giftYn = giftYn;
		this.dplfl = dplfl;
		this.newYn = newYn;
		this.salqty = salqty;
		this.salState = salState;
		this.prdImgnm = prdImgnm;
		this.prdImgurl = prdImgurl;
		this.prdType = prdType;
	}
	
}
