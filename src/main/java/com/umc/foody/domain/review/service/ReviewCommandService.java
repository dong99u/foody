package com.umc.foody.domain.review.service;

import com.umc.foody.domain.review.dto.ReviewRequestDto;

public interface ReviewCommandService {

	void createReview(ReviewRequestDto.CreateReview request);

}
