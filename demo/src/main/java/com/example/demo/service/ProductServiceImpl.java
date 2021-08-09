package com.example.demo.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProductBannerDto;
import com.example.demo.dto.ProductDetailDto;
import com.example.demo.entity.Product;
import com.example.demo.entity.ProductOption;
import com.example.demo.entity.QProduct;
import com.example.demo.entity.QProductDesc;
import com.example.demo.entity.QProductOption;
import com.example.demo.repository.ProductRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	JPAQueryFactory queryFactory;
	
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public Page<Product> getProductList(Integer pageNum) throws Exception {
		
		QProduct product = QProduct.product;
		
		BooleanBuilder builder = new BooleanBuilder();
		builder.and(product.dplfl.eq("Y"));
		
		Pageable pageable = PageRequest.of(pageNum-1, 5);
		
		List<Product> list = queryFactory.selectFrom(product)
				.where(builder)
				.offset(pageable.getOffset())
				.limit(pageable.getPageSize())
				.orderBy(product.regDate.desc())
				.fetch();
		
		long totalCount = queryFactory.selectFrom(product).where(builder).fetchCount();
		
		return new PageImpl<Product>(list, pageable, totalCount);
	}

	@Override
	public List<ProductBannerDto> getProductBannerList() throws Exception {
		QProduct product = QProduct.product;
		
		BooleanBuilder builder = new BooleanBuilder();
		builder.and(product.dplfl.eq("Y"));
		builder.and(product.prdAvg.goe(1));
		
		List<ProductBannerDto> list = queryFactory
				.select(Projections.constructor(ProductBannerDto.class,
						product.prdImgnm,
						product.prdImgurl))
				.from(product)
				.where(builder)
				.orderBy(product.prdAvg.desc())
				.limit(3)
				.fetch();

		return list;
	}

	@Override
	public Long productInfoCount(Integer prdno) throws Exception {

		QProduct product = QProduct.product;
		
		BooleanBuilder builder = new BooleanBuilder();
		builder.and(product.prdno.eq(prdno));
		
		return 	queryFactory.selectFrom(product).where(builder).fetchCount();
	}

	@Override
	public List<ProductDetailDto> getProductInfo(Integer prdno) throws Exception {
		QProduct product = QProduct.product;
		QProductOption productOption = QProductOption.productOption;
		QProductDesc desc = QProductDesc.productDesc;
		
		BooleanBuilder builder = new BooleanBuilder();
		builder.and(product.prdno.eq(prdno));
		builder.and(product.dplfl.eq("Y"));
		
		List<ProductDetailDto> productInfo = queryFactory
						.select(Projections.constructor(ProductDetailDto.class,
								product.prdno,
								product.prdnm,
								product.prdPrice,
								product.prdDesc,
								product.prdAvg,
								product.giftYn,
								product.newYn,
								product.prdImgurl,
								product.prdType,
								productOption.optno,
								productOption.optPrdno,
								productOption.optNm,
								productOption.optStock,
								productOption.optMain,
								productOption.optImgurl,
								desc.capacity,
								desc.makeCountry,
								desc.dateUse,
								desc.prdSkin,
								desc.prdPrecaution,
								desc.deliveryFee,
								product.likeCnt
								))
						.from(product)
						.leftJoin(productOption)
						.on(product.prdno.eq(productOption.optPrdno))
						.leftJoin(desc)
						.on(product.prdno.eq(desc.prdno))
						.where(builder)
						.fetch();
		
		return productInfo;
	}

	@Override
	public Map<String,Object> upProductLike(Integer prdno) throws Exception {
		
		QProduct product = QProduct.product;
		Map<String,Object> map = new HashMap<>();
		Product prd = queryFactory.selectFrom(product).where(product.prdno.eq(prdno)).fetchOne();
		long updProduct = queryFactory.update(product).set(product.likeCnt, (prd.getLikeCnt()+1)).where(product.prdno.eq(prdno)).execute();
		
		map.put("updProduct", updProduct);
		map.put("likecnt",prd.getLikeCnt()+1);
		
		return map;
	}

	@Override
	public Page<Product> getSearchList(String keyword, Integer pageNum) throws Exception {
		QProduct product = QProduct.product;
		
		BooleanBuilder builder = new BooleanBuilder();
		builder.and(product.prdnm.like("%"+keyword+"%"));
		
		Pageable pageable = PageRequest.of(pageNum-1, 5);
		
		List<Product> list = queryFactory.selectFrom(product)
				.where(builder)
				.offset(pageable.getOffset())
				.limit(pageable.getPageSize())
				.orderBy(product.regDate.desc())
				.fetch();
		
		long totalCount = queryFactory.selectFrom(product).where(builder).fetchCount();
		
		return new PageImpl<Product>(list, pageable, totalCount);
	}

	
}
