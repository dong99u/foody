package com.umc.foody.domain.mission.mapper;

import com.umc.foody.domain.mission.dto.MemberMissionResponseDto;
import com.umc.foody.domain.mission.entity.MemberMission;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberMissionMapper {

	public static MemberMissionResponseDto.MissionDto toMissionDto(MemberMission memberMission) {
		return MemberMissionResponseDto.MissionDto.builder()
			.id(memberMission.getId())
			.condition(memberMission.getMission().getCondition())
			.reward(memberMission.getMission().getReward())
			.storeId(memberMission.getMission().getStore().getId())
			.storeName(memberMission.getMission().getStore().getName())
			.status(memberMission.getStatus())
			.build();
	}
}
