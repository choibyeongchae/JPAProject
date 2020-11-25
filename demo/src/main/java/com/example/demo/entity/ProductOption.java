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
@Table(name="productoption")
@Builder
public class ProductOption {
	
	@Id
	Integer optno;
	
	@Column
	Integer optPrdno;
	
	@Column
	String optNm;
	
	@Column
	Integer optStock;
	
	@Column
	Integer optPrice;
	
	@Column
	String optMain;
	
	@Column
	Integer salqty;
	
	@Column
	String optImgnm;
	
	@Column
	String optImgurl;
	
	@Column
	private Date regDate;
	
	@Column
	private Date updDate;
	
	public ProductOption(Integer optno,String optNm, Integer optStock,
			Integer optPrice, String optMain, Integer salqty,
			String optImgnm, String optImgurl) {
		this.optno = optno;
		this.optNm = optNm;
		this.optStock = optStock;
		this.optPrice = optPrice;
		this.optMain = optMain;
		this.salqty = salqty;
		this.optImgnm = optImgnm;
		this.optImgurl = optImgurl;
	}
}
