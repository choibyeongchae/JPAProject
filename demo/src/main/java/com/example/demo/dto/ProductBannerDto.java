package com.example.demo.dto;

import com.querydsl.core.annotations.QueryProjection;

import lombok.Data;

@Data
public class ProductBannerDto {

	private String prdImgnm;
	private String prdImgurl;
		
	@QueryProjection
	public ProductBannerDto(String prdImgnm, String prdImgurl) {
		this.prdImgnm = prdImgnm;
		this.prdImgurl = prdImgurl;
	}
}
