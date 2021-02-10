package com.example.demo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QProductDesc is a Querydsl query type for ProductDesc
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProductDesc extends EntityPathBase<ProductDesc> {

    private static final long serialVersionUID = -148203665L;

    public static final QProductDesc productDesc = new QProductDesc("productDesc");

    public final NumberPath<Integer> capacity = createNumber("capacity", Integer.class);

    public final StringPath dateUse = createString("dateUse");

    public final NumberPath<Integer> deliveryFee = createNumber("deliveryFee", Integer.class);

    public final StringPath makeCountry = createString("makeCountry");

    public final NumberPath<Integer> prdno = createNumber("prdno", Integer.class);

    public final StringPath prdPrecaution = createString("prdPrecaution");

    public final StringPath prdSkin = createString("prdSkin");

    public final DatePath<java.sql.Date> regDate = createDate("regDate", java.sql.Date.class);

    public final DatePath<java.sql.Date> updDate = createDate("updDate", java.sql.Date.class);

    public QProductDesc(String variable) {
        super(ProductDesc.class, forVariable(variable));
    }

    public QProductDesc(Path<? extends ProductDesc> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProductDesc(PathMetadata metadata) {
        super(ProductDesc.class, metadata);
    }

}

