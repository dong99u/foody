package com.umc.foody.domain.store.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStore is a Querydsl query type for Store
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStore extends EntityPathBase<Store> {

    private static final long serialVersionUID = 260633834L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStore store = new QStore("store");

    public final com.umc.foody.global.common.QBaseEntity _super = new com.umc.foody.global.common.QBaseEntity(this);

    public final com.umc.foody.auth.member.entity.QAddress address;

    public final TimePath<java.time.LocalTime> closeTime = createTime("closeTime", java.time.LocalTime.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<com.umc.foody.domain.mission.entity.Mission, com.umc.foody.domain.mission.entity.QMission> missions = this.<com.umc.foody.domain.mission.entity.Mission, com.umc.foody.domain.mission.entity.QMission>createList("missions", com.umc.foody.domain.mission.entity.Mission.class, com.umc.foody.domain.mission.entity.QMission.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final TimePath<java.time.LocalTime> openTime = createTime("openTime", java.time.LocalTime.class);

    public final StringPath phoneNumber = createString("phoneNumber");

    public final NumberPath<Double> rating = createNumber("rating", Double.class);

    public final ListPath<com.umc.foody.domain.review.entity.Review, com.umc.foody.domain.review.entity.QReview> reviews = this.<com.umc.foody.domain.review.entity.Review, com.umc.foody.domain.review.entity.QReview>createList("reviews", com.umc.foody.domain.review.entity.Review.class, com.umc.foody.domain.review.entity.QReview.class, PathInits.DIRECT2);

    public final com.umc.foody.auth.member.entity.QStoreOwner storeOwner;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QStore(String variable) {
        this(Store.class, forVariable(variable), INITS);
    }

    public QStore(Path<? extends Store> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStore(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStore(PathMetadata metadata, PathInits inits) {
        this(Store.class, metadata, inits);
    }

    public QStore(Class<? extends Store> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.address = inits.isInitialized("address") ? new com.umc.foody.auth.member.entity.QAddress(forProperty("address")) : null;
        this.storeOwner = inits.isInitialized("storeOwner") ? new com.umc.foody.auth.member.entity.QStoreOwner(forProperty("storeOwner"), inits.get("storeOwner")) : null;
    }

}

