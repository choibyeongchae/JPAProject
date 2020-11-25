package com.example.demo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QProduct is a Querydsl query type for Product
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProduct extends EntityPathBase<Product> {

    private static final long serialVersionUID = 15086526L;

    public static final QProduct product = new QProduct("product");

    public final StringPath cate = createString("cate");

    public final StringPath dplfl = createString("dplfl");

    public final StringPath giftYn = createString("giftYn");

    public final NumberPath<Integer> likeCnt = createNumber("likeCnt", Integer.class);

    public final StringPath newYn = createString("newYn");

    public final NumberPath<Double> prdAvg = createNumber("prdAvg", Double.class);

    public final StringPath prdDesc = createString("prdDesc");

    public final StringPath prdImgnm = createString("prdImgnm");

    public final StringPath prdImgurl = createString("prdImgurl");

    public final StringPath prdnm = createString("prdnm");

    public final NumberPath<Integer> prdno = createNumber("prdno", Integer.class);

    public final NumberPath<Integer> prdPrice = createNumber("prdPrice", Integer.class);

    public final StringPath prdType = createString("prdType");

    public final DatePath<java.sql.Date> regDate = createDate("regDate", java.sql.Date.class);

    public final NumberPath<Integer> salqty = createNumber("salqty", Integer.class);

    public final StringPath salState = createString("salState");

    public final DatePath<java.sql.Date> updDate = createDate("updDate", java.sql.Date.class);

    public QProduct(String variable) {
        super(Product.class, forVariable(variable));
    }

    public QProduct(Path<? extends Product> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProduct(PathMetadata metadata) {
        super(Product.class, metadata);
    }

}

