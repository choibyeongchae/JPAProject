package com.example.demo.dto;

import javax.persistence.Column;

import com.querydsl.core.annotations.QueryProjection;

import lombok.Data;

@Data
public class ProductDetailDto {

	private Integer prdno;
	
	private String prdnm;
	
	private Integer prdPrice;
	
	private String prdDesc;
	
	private Double prdAvg;
	
	private String giftYn;
	
	private String newYn;
	
	private String prdImgurl;
	
	private String prdType;
	
	private Integer optno;
	
	private Integer optPrdno;
	
	private String optNm;
	
	private Integer optStock;
	
	private String optMain;
	
	private String optImgurl;
	
	private Integer capacity;
	
	private String makeCountry;
	
	private String dateUse;
	
	private String prdSkin;
	
	private String prdPrecaution;
	
	private Integer deliveryFee;
	
	private Integer likeCnt;
	
	@QueryProjection
	public ProductDetailDto(Integer prdno, String prdnm, Integer prdPrice, String prdDesc, Double prdAvg, String giftYn
			, String newYn, String prdImgurl, String prdType, Integer optno, Integer optPrdno
			, String optNm, Integer optStock, String optMain, String optImgurl
			, Integer capacity, String makeCountry, String dateUse, String prdSkin, String prdPrecaution, Integer deliveryFee
			, Integer likeCnt) {
		this.prdno = prdno;
		this.prdnm = prdnm;
		this.prdPrice = prdPrice;
		this.prdDesc = prdDesc;
		this.prdAvg = prdAvg;
		this.giftYn = giftYn;
		this.newYn = newYn;
		this.prdImgurl = prdImgurl;
		this.prdType = prdType;
		this.optno = optno;
		this.optPrdno = optPrdno;
		this.optNm = optNm;
		this.optStock = optStock;
		this.optMain = optMain;
		this.optImgurl = optImgurl;
		this.capacity = capacity;
		this.makeCountry = makeCountry;
		this.dateUse = dateUse;
		this.prdSkin = prdSkin;
		this.prdPrecaution = prdPrecaution;
		this.deliveryFee = deliveryFee;
		this.likeCnt = likeCnt;
		
	}
	
}
