package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.dto.ProductBannerDto;
import com.example.demo.entity.Product;

public interface ProductService {

	public Page<Product> getProductList(Integer pageNum) throws Exception;
	
	public List<ProductBannerDto> getProductBannerList() throws Exception;
}
