package com.example.demo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMemberEntity is a Querydsl query type for MemberEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMemberEntity extends EntityPathBase<MemberEntity> {

    private static final long serialVersionUID = -2081947218L;

    public static final QMemberEntity memberEntity = new QMemberEntity("memberEntity");

    public final StringPath address = createString("address");

    public final StringPath birth = createString("birth");

    public final StringPath email = createString("email");

    public final StringPath mbrGrade = createString("mbrGrade");

    public final StringPath mbrNm = createString("mbrNm");

    public final NumberPath<Integer> mbrno = createNumber("mbrno", Integer.class);

    public final NumberPath<Integer> mbrPoint = createNumber("mbrPoint", Integer.class);

    public final StringPath password = createString("password");

    public final StringPath phone = createString("phone");

    public final DatePath<java.sql.Date> regDate = createDate("regDate", java.sql.Date.class);

    public final DatePath<java.sql.Date> updDate = createDate("updDate", java.sql.Date.class);

    public QMemberEntity(String variable) {
        super(MemberEntity.class, forVariable(variable));
    }

    public QMemberEntity(Path<? extends MemberEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMemberEntity(PathMetadata metadata) {
        super(MemberEntity.class, metadata);
    }

}

