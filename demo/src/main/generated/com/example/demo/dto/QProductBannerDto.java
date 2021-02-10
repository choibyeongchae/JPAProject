package com.example.demo.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.Generated;

/**
 * com.example.demo.dto.QProductBannerDto is a Querydsl Projection type for ProductBannerDto
 */
@Generated("com.querydsl.codegen.ProjectionSerializer")
public class QProductBannerDto extends ConstructorExpression<ProductBannerDto> {

    private static final long serialVersionUID = 857564589L;

    public QProductBannerDto(com.querydsl.core.types.Expression<String> prdImgnm, com.querydsl.core.types.Expression<String> prdImgurl) {
        super(ProductBannerDto.class, new Class<?>[]{String.class, String.class}, prdImgnm, prdImgurl);
    }

}

