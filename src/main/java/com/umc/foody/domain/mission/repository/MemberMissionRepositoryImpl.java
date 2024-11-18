package com.umc.foody.domain.mission.repository;

import static com.umc.foody.auth.member.entity.QCustomer.*;
import static com.umc.foody.domain.mission.entity.QMemberMission.*;
import static com.umc.foody.domain.mission.entity.QMission.*;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.umc.foody.domain.member_mission.entity.MemberMission;
import com.umc.foody.domain.member_mission.entity.MissionStatus;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MemberMissionRepositoryImpl implements MemberMissionRepository {

	private final JPAQueryFactory jpaQueryFactory;

	@Override
	public List<MemberMission> findMemberMissionsWithScroll(Long lastId, int size) {

		return jpaQueryFactory
			.selectFrom(memberMission)
			.join(memberMission.customer, customer).fetchJoin()
			.join(memberMission.mission, mission).fetchJoin()
			.where(
				memberMission.status.in(MissionStatus.PROGRESS, MissionStatus.COMPLETE),
				memberMission.id.lt(lastId)
			)
			.orderBy(memberMission.id.desc())
			.limit(size)
			.fetch();
	}
}
