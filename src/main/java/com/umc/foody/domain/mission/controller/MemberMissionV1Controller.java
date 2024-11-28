package com.umc.foody.domain.mission.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.umc.foody.domain.mission.dto.MemberMissionResponseDto;
import com.umc.foody.domain.mission.service.MemberMissionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/member-missions")
@RequiredArgsConstructor
public class MemberMissionV1Controller {

	private final MemberMissionService memberMissionService;

	@GetMapping("/scroll")
	public ResponseEntity<List<MemberMissionResponseDto.MissionDto>> getMemberMissions(
		@RequestParam(required = false) Long lastId,
		@RequestParam(defaultValue = "10") int size
	) {
		return ResponseEntity.ok(memberMissionService.getMemberMissionsWithScroll(lastId, size));
	}
}
