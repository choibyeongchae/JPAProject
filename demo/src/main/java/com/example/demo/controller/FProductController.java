package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.ProductBannerDto;
import com.example.demo.dto.ProductDetailDto;
import com.example.demo.entity.Product;
import com.example.demo.entity.ProductOption;
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
		
		List<ProductBannerDto> list = new ArrayList<>();
		
		try {
			list = productService.getProductBannerList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	
	@RequestMapping(value ="/productDetail",method=RequestMethod.GET)
	public void productDetail(Model model,@RequestParam(value ="prdno") Integer prdno,HttpServletRequest request) throws Exception
	{
		try {
			
			Cookie[] cookieArr = request.getCookies();
			boolean cookieCurrentPrdAdd = true;
			String cookieMsg = "";
			for (Cookie cookie : cookieArr) {
				if (cookie.getName().equals("likeProduct")) {
					String str[] = cookie.getValue().split("\\|");
					for (String s : str) {
						if (Integer.parseInt(s) == prdno) {
							cookieCurrentPrdAdd = false;
						}
					}
					
				}
			}
			
			if (!cookieCurrentPrdAdd) {
				cookieMsg = "disable";
			}
			
			Long prdInfoCount = productService.productInfoCount(prdno);
			
			if (prdInfoCount < 1) {
				throw new Exception();
			}
			model.addAttribute("prdno",prdno);
			model.addAttribute("cookieMsg", cookieMsg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping(value ="/getProductInfo",method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getProductInfo(Model model,@RequestParam(value = "prdno") Integer prdno) throws Exception {
		
		Map<String, Object> prdMap = new HashMap<String, Object>();
		try {

			List<ProductDetailDto> productInfo = productService.getProductInfo(prdno);

			prdMap.put("productInfo", productInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prdMap;
	}
	
	@RequestMapping(value ="/upProductlikeCnt",method=RequestMethod.GET)
	@ResponseBody
	@Transactional
	public Map<String, Object> upProductlikeCnt(Model model,@RequestParam(value = "prdno") Integer prdno, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Map<String,Object> rtnMap = new HashMap<>();
		Map<String,Object> updMap = new HashMap<String, Object>();
		Cookie[] cookieArr = request.getCookies();
		String cookieVal = "";
		for (Cookie cookie : cookieArr) {
			if (cookie.getName().equals("likeProduct")) {
				cookieVal+= cookie.getValue();
			}
		}
		
		updMap = productService.upProductLike(prdno);
		
		if (Integer.parseInt(String.valueOf(updMap.get("updProduct"))) == 1) {
			rtnMap.put("rtnMsg", "success");
			rtnMap.put("resultLikeCnt", Integer.parseInt(String.valueOf(updMap.get("likecnt"))));
			if (cookieVal.equals("")) {
				Cookie cookie = new Cookie("likeProduct", String.valueOf(prdno));
				response.addCookie(cookie);
			} else {
				cookieVal += "|" + prdno;
				Cookie cookie = new Cookie("likeProduct", cookieVal);
				response.addCookie(cookie);
			}
		} else {
			rtnMap.put("rtnMsg", "fail");
		}
		
		return rtnMap;
	}
	
	@RequestMapping(value ="/getSearchList",method=RequestMethod.GET)
	@ResponseBody
	@Transactional
	public Page<Product> getSearchResult(Model model,@RequestParam(value = "keyword") String keyword, @RequestParam(value ="pageNum", required=false) Integer pageNum, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		if (pageNum == null) {
			pageNum = 1;
		}

		Page<Product> searchResult = null;

		try {
			searchResult = productService.getSearchList(keyword, pageNum);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return searchResult;
	}
}
