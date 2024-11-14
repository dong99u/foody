package com.umc.foody.domain.mission.service;

import java.util.List;

import com.umc.foody.domain.mission.dto.MemberMissionResponseDto;

public interface MemberMissionService {
	List<MemberMissionResponseDto.MissionDto> getMemberMissionsWithScroll(Long lastId, int size);

}
