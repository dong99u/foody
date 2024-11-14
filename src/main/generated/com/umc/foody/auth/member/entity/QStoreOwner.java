package com.umc.foody.auth.member.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStoreOwner is a Querydsl query type for StoreOwner
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStoreOwner extends EntityPathBase<StoreOwner> {

    private static final long serialVersionUID = -708092244L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStoreOwner storeOwner = new QStoreOwner("storeOwner");

    public final QMember _super;

    // inherited
    public final QAddress address;

    //inherited
    public final DatePath<java.time.LocalDate> birthDate;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt;

    //inherited
    public final EnumPath<Gender> gender;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> inactivatedAt;

    //inherited
    public final BooleanPath isDeleted;

    //inherited
    public final StringPath name;

    //inherited
    public final StringPath phoneNumber;

    public final QAddress storeAddress;

    public final StringPath storeName = createString("storeName");

    public final StringPath storePhoneNumber = createString("storePhoneNumber");

    public final ListPath<com.umc.foody.domain.store.entity.Store, com.umc.foody.domain.store.entity.QStore> stores = this.<com.umc.foody.domain.store.entity.Store, com.umc.foody.domain.store.entity.QStore>createList("stores", com.umc.foody.domain.store.entity.Store.class, com.umc.foody.domain.store.entity.QStore.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt;

    public QStoreOwner(String variable) {
        this(StoreOwner.class, forVariable(variable), INITS);
    }

    public QStoreOwner(Path<? extends StoreOwner> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStoreOwner(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStoreOwner(PathMetadata metadata, PathInits inits) {
        this(StoreOwner.class, metadata, inits);
    }

    public QStoreOwner(Class<? extends StoreOwner> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QMember(type, metadata, inits);
        this.address = _super.address;
        this.birthDate = _super.birthDate;
        this.createdAt = _super.createdAt;
        this.gender = _super.gender;
        this.inactivatedAt = _super.inactivatedAt;
        this.isDeleted = _super.isDeleted;
        this.name = _super.name;
        this.phoneNumber = _super.phoneNumber;
        this.storeAddress = inits.isInitialized("storeAddress") ? new QAddress(forProperty("storeAddress")) : null;
        this.updatedAt = _super.updatedAt;
    }

}

