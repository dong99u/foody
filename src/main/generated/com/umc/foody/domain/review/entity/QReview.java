package com.umc.foody.domain.review.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReview is a Querydsl query type for Review
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReview extends EntityPathBase<Review> {

    private static final long serialVersionUID = -14447596L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReview review = new QReview("review");

    public final com.umc.foody.global.common.QBaseEntity _super = new com.umc.foody.global.common.QBaseEntity(this);

    public final ListPath<com.umc.foody.domain.comment.entity.Comment, com.umc.foody.domain.comment.entity.QComment> comments = this.<com.umc.foody.domain.comment.entity.Comment, com.umc.foody.domain.comment.entity.QComment>createList("comments", com.umc.foody.domain.comment.entity.Comment.class, com.umc.foody.domain.comment.entity.QComment.class, PathInits.DIRECT2);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final com.umc.foody.auth.member.entity.QCustomer customer;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Double> rating = createNumber("rating", Double.class);

    public final ListPath<com.umc.foody.domain.reviewimage.entity.ReviewImage, com.umc.foody.domain.reviewimage.entity.QReviewImage> reviewImages = this.<com.umc.foody.domain.reviewimage.entity.ReviewImage, com.umc.foody.domain.reviewimage.entity.QReviewImage>createList("reviewImages", com.umc.foody.domain.reviewimage.entity.ReviewImage.class, com.umc.foody.domain.reviewimage.entity.QReviewImage.class, PathInits.DIRECT2);

    public final com.umc.foody.domain.store.entity.QStore store;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QReview(String variable) {
        this(Review.class, forVariable(variable), INITS);
    }

    public QReview(Path<? extends Review> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReview(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReview(PathMetadata metadata, PathInits inits) {
        this(Review.class, metadata, inits);
    }

    public QReview(Class<? extends Review> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.customer = inits.isInitialized("customer") ? new com.umc.foody.auth.member.entity.QCustomer(forProperty("customer"), inits.get("customer")) : null;
        this.store = inits.isInitialized("store") ? new com.umc.foody.domain.store.entity.QStore(forProperty("store"), inits.get("store")) : null;
    }

}

