package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.example.demo.dto.ProductBannerDto;
import com.example.demo.dto.ProductDetailDto;
import com.example.demo.entity.Product;

public interface ProductService {

	public Page<Product> getProductList(Integer pageNum) throws Exception;
	
	public List<ProductBannerDto> getProductBannerList() throws Exception;
	
	public Long productInfoCount(Integer prdno) throws Exception;
	
	public List<ProductDetailDto> getProductInfo(Integer prdno) throws Exception;
	
	public Map<String,Object>  upProductLike(Integer prdno) throws Exception;
}
