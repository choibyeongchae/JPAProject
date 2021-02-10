package com.example.demo.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.Generated;

/**
 * com.example.demo.dto.QProductDetailDto is a Querydsl Projection type for ProductDetailDto
 */
@Generated("com.querydsl.codegen.ProjectionSerializer")
public class QProductDetailDto extends ConstructorExpression<ProductDetailDto> {

    private static final long serialVersionUID = 580320872L;

    public QProductDetailDto(com.querydsl.core.types.Expression<Integer> prdno, com.querydsl.core.types.Expression<String> prdnm, com.querydsl.core.types.Expression<Integer> prdPrice, com.querydsl.core.types.Expression<String> prdDesc, com.querydsl.core.types.Expression<Double> prdAvg, com.querydsl.core.types.Expression<String> giftYn, com.querydsl.core.types.Expression<String> newYn, com.querydsl.core.types.Expression<String> prdImgurl, com.querydsl.core.types.Expression<String> prdType, com.querydsl.core.types.Expression<Integer> optno, com.querydsl.core.types.Expression<Integer> optPrdno, com.querydsl.core.types.Expression<String> optNm, com.querydsl.core.types.Expression<Integer> optStock, com.querydsl.core.types.Expression<String> optMain, com.querydsl.core.types.Expression<String> optImgurl) {
        super(ProductDetailDto.class, new Class<?>[]{int.class, String.class, int.class, String.class, double.class, String.class, String.class, String.class, String.class, int.class, int.class, String.class, int.class, String.class, String.class}, prdno, prdnm, prdPrice, prdDesc, prdAvg, giftYn, newYn, prdImgurl, prdType, optno, optPrdno, optNm, optStock, optMain, optImgurl);
    }

}

