package com.umc.foody.domain.foodcategory.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFavoriteFoodCategory is a Querydsl query type for FavoriteFoodCategory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFavoriteFoodCategory extends EntityPathBase<FavoriteFoodCategory> {

    private static final long serialVersionUID = 972415928L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFavoriteFoodCategory favoriteFoodCategory = new QFavoriteFoodCategory("favoriteFoodCategory");

    public final com.umc.foody.global.common.QBaseEntity _super = new com.umc.foody.global.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final com.umc.foody.auth.member.entity.QCustomer customer;

    public final QFoodCategory foodCategory;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QFavoriteFoodCategory(String variable) {
        this(FavoriteFoodCategory.class, forVariable(variable), INITS);
    }

    public QFavoriteFoodCategory(Path<? extends FavoriteFoodCategory> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QFavoriteFoodCategory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QFavoriteFoodCategory(PathMetadata metadata, PathInits inits) {
        this(FavoriteFoodCategory.class, metadata, inits);
    }

    public QFavoriteFoodCategory(Class<? extends FavoriteFoodCategory> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.customer = inits.isInitialized("customer") ? new com.umc.foody.auth.member.entity.QCustomer(forProperty("customer"), inits.get("customer")) : null;
        this.foodCategory = inits.isInitialized("foodCategory") ? new QFoodCategory(forProperty("foodCategory")) : null;
    }

}

