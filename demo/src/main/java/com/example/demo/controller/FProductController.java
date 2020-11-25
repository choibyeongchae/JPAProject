package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.ProductBannerDto;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@Controller
@RequestMapping("/product/*")
public class FProductController {

	@Autowired ProductService productService;
	
	@RequestMapping(value ="/productList",method=RequestMethod.GET)
	public void productList(Model model,@RequestParam(value ="pageNum", required=false) Integer pageNum)
	{
		if (pageNum == null) {
			pageNum = 1;
		}
		
		model.addAttribute("pageNum", pageNum);
	}
	
	@RequestMapping(value ="/getProductList",method=RequestMethod.GET)
	@ResponseBody
	public Page<Product> getProductList(@RequestParam(value ="pageNum", required=false) Integer pageNum) throws Exception {
		
		if (pageNum == null) {
			pageNum = 1;
		}
		
		Page<Product> list = productService.getProductList(pageNum);
		
		return list;
	}
	
	@RequestMapping(value ="/getProductBannerList",method=RequestMethod.GET)
	@ResponseBody
	public List<ProductBannerDto> getProductBannerList(Model model) throws Exception {
		
		List<ProductBannerDto> list = productService.getProductBannerList();
		
		return list;
	}
}
