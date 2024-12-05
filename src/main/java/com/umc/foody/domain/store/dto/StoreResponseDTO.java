package com.umc.foody.domain.store.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StoreResponseDTO {

	@Getter
	@Builder
	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	@AllArgsConstructor
	public static class ReviewPreviewsDto {
		List<ReviewPreviewDto> reviewList;
		Integer listSize;
		Integer totalPage;
		Long totalElements;
		Boolean isFirst;
		Boolean isLast;

	}

	@Getter
	@Builder
	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	@AllArgsConstructor
	public static class ReviewPreviewDto {
		String ownerNickname;

		Double score;

		String body;

		LocalDate createdAt;
	}
}
