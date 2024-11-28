package com.umc.foody.domain.review.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.umc.foody.domain.review.dto.ReviewRequestDto;
import com.umc.foody.domain.review.repository.ReviewJpaRepository;
import com.umc.foody.domain.store.repository.StoreRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

	private final ReviewJpaRepository reviewJpaRepository;
	private final StoreRepository storeRepository;

	@Override
	public void createReview(ReviewRequestDto.CreateReview request) {
		// TODO Auto-generated method stub
	}
}
