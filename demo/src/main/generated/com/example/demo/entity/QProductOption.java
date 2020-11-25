package com.example.demo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QProductOption is a Querydsl query type for ProductOption
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProductOption extends EntityPathBase<ProductOption> {

    private static final long serialVersionUID = -364682797L;

    public static final QProductOption productOption = new QProductOption("productOption");

    public final StringPath optImgnm = createString("optImgnm");

    public final StringPath optImgurl = createString("optImgurl");

    public final StringPath optMain = createString("optMain");

    public final StringPath optNm = createString("optNm");

    public final NumberPath<Integer> optno = createNumber("optno", Integer.class);

    public final NumberPath<Integer> optPrdno = createNumber("optPrdno", Integer.class);

    public final NumberPath<Integer> optPrice = createNumber("optPrice", Integer.class);

    public final NumberPath<Integer> optStock = createNumber("optStock", Integer.class);

    public final DatePath<java.sql.Date> regDate = createDate("regDate", java.sql.Date.class);

    public final NumberPath<Integer> salqty = createNumber("salqty", Integer.class);

    public final DatePath<java.sql.Date> updDate = createDate("updDate", java.sql.Date.class);

    public QProductOption(String variable) {
        super(ProductOption.class, forVariable(variable));
    }

    public QProductOption(Path<? extends ProductOption> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProductOption(PathMetadata metadata) {
        super(ProductOption.class, metadata);
    }

}

