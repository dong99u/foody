package com.umc.foody.domain.store.service.query;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.umc.foody.domain.review.dto.ReviewResponseDto;
import com.umc.foody.domain.review.entity.Review;
import com.umc.foody.domain.review.repository.ReviewJpaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreQueryServiceImpl implements StoreQueryService {

	private final ReviewJpaRepository reviewJpaRepository;

	@Override
	public ReviewResponseDto.ReviewsResponse getReviews(Long storeId, Integer page, Integer size) {

		Page<Review> reviewPage = reviewJpaRepository.findReviewsAndStoresAndCustomersByStoreId(storeId,
			PageRequest.of(page, size));

		List<ReviewResponseDto.ReviewResponse> reviewResponses =
			ReviewResponseDto.ReviewResponse.listFrom(reviewPage.getContent());

		return ReviewResponseDto.ReviewsResponse.of(reviewPage, reviewResponses);

	}
}
