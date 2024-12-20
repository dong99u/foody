package com.umc.foody.domain.review.dto;

import com.umc.foody.global.validation.annotation.ExistsMemberId;
import com.umc.foody.global.validation.annotation.ExistsStoreId;

import jakarta.validation.constraints.NotEmpty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReviewRequestDto {

	@Getter
	@Builder
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	@AllArgsConstructor
	public static class CreateReview {

		@ExistsStoreId
		Long storeId;

		@ExistsMemberId
		Long memberId;

		@NotEmpty
		String content;

		@NotEmpty
		Double rating;
	}
}
