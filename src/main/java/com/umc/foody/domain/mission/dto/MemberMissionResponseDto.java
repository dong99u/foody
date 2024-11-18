package com.umc.foody.domain.mission.dto;

import com.umc.foody.domain.member_mission.entity.MissionStatus;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberMissionResponseDto {

	@Getter
	@Builder
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	@AllArgsConstructor
	public static class MissionDto {
		private Long id;

		private Integer condition; // 미션 조건

		private Double reward; // 미션 보상

		private Long storeId; // 가게 ID

		private String storeName; // 가게 이름

		private MissionStatus status; // 미션 상태

	}

}
