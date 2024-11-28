package com.umc.foody.domain.alarm.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMissionAlarm is a Querydsl query type for MissionAlarm
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMissionAlarm extends EntityPathBase<MissionAlarm> {

    private static final long serialVersionUID = -990928532L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMissionAlarm missionAlarm = new QMissionAlarm("missionAlarm");

    public final QAlarm _super;

    //inherited
    public final StringPath content;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt;

    // inherited
    public final com.umc.foody.auth.member.entity.QCustomer customer;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final BooleanPath isRead;

    //inherited
    public final StringPath title;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt;

    public QMissionAlarm(String variable) {
        this(MissionAlarm.class, forVariable(variable), INITS);
    }

    public QMissionAlarm(Path<? extends MissionAlarm> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMissionAlarm(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMissionAlarm(PathMetadata metadata, PathInits inits) {
        this(MissionAlarm.class, metadata, inits);
    }

    public QMissionAlarm(Class<? extends MissionAlarm> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QAlarm(type, metadata, inits);
        this.content = _super.content;
        this.createdAt = _super.createdAt;
        this.customer = _super.customer;
        this.isRead = _super.isRead;
        this.title = _super.title;
        this.updatedAt = _super.updatedAt;
    }

}

