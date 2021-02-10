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
@Table(name="productdesc")
@Builder
public class ProductDesc {
	
	@Id
	private Integer prdno;
	
	@Column
	private Integer capacity;
	
	@Column
	private String makeCountry;
	
	@Column
	private String dateUse;
	
	@Column
	private String prdSkin;
	
	@Column
	private String prdPrecaution;
	
	@Column
	private Integer deliveryFee;
	
	@Column
	private Date regDate;
	
	@Column
	private Date updDate;
	
}
