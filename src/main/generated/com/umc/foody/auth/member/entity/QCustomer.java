package com.umc.foody.auth.member.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;
import com.umc.foody.domain.member_mission.entity.MemberMission;

/**
 * QCustomer is a Querydsl query type for Customer
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCustomer extends EntityPathBase<Customer> {

    private static final long serialVersionUID = 99466936L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCustomer customer = new QCustomer("customer");

    public final QMember _super;

    // inherited
    public final QAddress address;

    public final ListPath<com.umc.foody.domain.alarm.entity.Alarm, com.umc.foody.domain.alarm.entity.QAlarm> alarms = this.<com.umc.foody.domain.alarm.entity.Alarm, com.umc.foody.domain.alarm.entity.QAlarm>createList("alarms", com.umc.foody.domain.alarm.entity.Alarm.class, com.umc.foody.domain.alarm.entity.QAlarm.class, PathInits.DIRECT2);

    //inherited
    public final DatePath<java.time.LocalDate> birthDate;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt;

    public final ListPath<com.umc.foody.domain.foodcategory.entity.FavoriteFoodCategory, com.umc.foody.domain.foodcategory.entity.QFavoriteFoodCategory> favoriteFoodCategories = this.<com.umc.foody.domain.foodcategory.entity.FavoriteFoodCategory, com.umc.foody.domain.foodcategory.entity.QFavoriteFoodCategory>createList("favoriteFoodCategories", com.umc.foody.domain.foodcategory.entity.FavoriteFoodCategory.class, com.umc.foody.domain.foodcategory.entity.QFavoriteFoodCategory.class, PathInits.DIRECT2);

    //inherited
    public final EnumPath<Gender> gender;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> inactivatedAt;

    //inherited
    public final BooleanPath isDeleted;

    public final ListPath<MemberMission, com.umc.foody.domain.mission.entity.QMemberMission> memberMissions = this.<MemberMission, com.umc.foody.domain.mission.entity.QMemberMission>createList("memberMissions", MemberMission.class, com.umc.foody.domain.mission.entity.QMemberMission.class, PathInits.DIRECT2);

    //inherited
    public final StringPath name;

    //inherited
    public final StringPath phoneNumber;

    public final NumberPath<Integer> points = createNumber("points", Integer.class);

    public final ListPath<com.umc.foody.domain.review.entity.Review, com.umc.foody.domain.review.entity.QReview> reviews = this.<com.umc.foody.domain.review.entity.Review, com.umc.foody.domain.review.entity.QReview>createList("reviews", com.umc.foody.domain.review.entity.Review.class, com.umc.foody.domain.review.entity.QReview.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt;

    public QCustomer(String variable) {
        this(Customer.class, forVariable(variable), INITS);
    }

    public QCustomer(Path<? extends Customer> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCustomer(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCustomer(PathMetadata metadata, PathInits inits) {
        this(Customer.class, metadata, inits);
    }

    public QCustomer(Class<? extends Customer> type, PathMetadata metadata, PathInits inits) {
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
        this.updatedAt = _super.updatedAt;
    }

}

