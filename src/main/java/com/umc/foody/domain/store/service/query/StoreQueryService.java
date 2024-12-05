package com.umc.foody.domain.store.service.query;

import com.umc.foody.domain.review.dto.ReviewResponseDto;

public interface StoreQueryService {
	ReviewResponseDto.ReviewsResponse getReviews(Long storeId, Integer page, Integer size);
}
