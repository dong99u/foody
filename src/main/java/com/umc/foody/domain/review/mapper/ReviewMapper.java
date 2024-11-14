package com.umc.foody.domain.review.mapper;

import com.umc.foody.auth.member.entity.Customer;
import com.umc.foody.domain.review.dto.ReviewRequestDto;
import com.umc.foody.domain.review.entity.Review;
import com.umc.foody.domain.store.entity.Store;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReviewMapper {

	public static Review toReview(Store store, Customer customer, ReviewRequestDto.CreateReview request) {
		return Review.builder()
			.store(store)
			.customer(customer)
			.content(request.getContent())
			.rating(request.getRating())
			.build();

	}
}
