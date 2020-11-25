package com.example.demo.service;

import java.util.List;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProductBannerDto;
import com.example.demo.entity.Product;
import com.example.demo.entity.QProduct;
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

	
}
