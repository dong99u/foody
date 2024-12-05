package com.umc.foody.domain.review.dto;

import java.util.List;

import org.springframework.data.domain.Page;

import com.umc.foody.domain.review.entity.Review;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReviewResponseDto {

	@Getter
	@Builder
	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	@AllArgsConstructor
	public static class ReviewsResponse {
		boolean isLast;
		boolean isFirst;

		Integer totalPage;
		Long totalElements;
		Integer listSize;

		List<ReviewResponse> reviewList;

		// Page<Review>로부터 ReviewsResponse를 생성하는 팩토리 메서드
		public static ReviewsResponse of(Page<Review> reviewPage, List<ReviewResponse> reviews) {
			return ReviewsResponse.builder()
				.isLast(reviewPage.isLast())
				.isFirst(reviewPage.isFirst())
				.totalPage(reviewPage.getTotalPages())
				.totalElements(reviewPage.getTotalElements())
				.listSize(reviews.size())
				.reviewList(reviews)
				.build();
		}

	}

	@Getter
	@Builder
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	@AllArgsConstructor
	public static class ReviewResponse {
		Long reviewId;
		Long storeId;
		Long memberId;
		String content;
		Double rating;

		public static ReviewResponse from(Review review) {
			return ReviewResponse.builder()
				.reviewId(review.getId())
				.storeId(review.getStore().getId())
				.memberId(review.getCustomer().getId())
				.content(review.getContent())
				.rating(review.getRating())
				.build();
		}

		// Review 엔티티 리스트로부터 ReviewResponse 리스트를 생성
		public static List<ReviewResponse> listFrom(List<Review> reviews) {
			return reviews.stream()
				.map(ReviewResponse::from)
				.toList();
		}
	}
}
