package com.umc.foody.domain.mission.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.umc.foody.domain.mission.dto.MemberMissionResponseDto;
import com.umc.foody.domain.mission.entity.MemberMission;
import com.umc.foody.domain.mission.mapper.MemberMissionMapper;
import com.umc.foody.domain.mission.repository.MemberMissionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberMissionServiceImpl implements MemberMissionService {

	private final MemberMissionRepository memberMissionRepository;

	@Override
	public List<MemberMissionResponseDto.MissionDto> getMemberMissionsWithScroll(Long lastId, int size) {
		List<MemberMission> memberMissions = memberMissionRepository.findMemberMissionsWithScroll(lastId,
			size);

		return memberMissions.stream().map(MemberMissionMapper::toMissionDto).toList();

	}
}
