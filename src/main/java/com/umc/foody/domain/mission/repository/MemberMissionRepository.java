package com.umc.foody.domain.mission.repository;

import java.util.List;

import com.umc.foody.domain.member_mission.entity.MemberMission;

public interface MemberMissionRepository {
	List<MemberMission> findMemberMissionsWithScroll(Long lastId, int size);
}
