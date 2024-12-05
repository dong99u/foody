package com.umc.foody.domain.review.service.command;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.umc.foody.auth.member.entity.Customer;
import com.umc.foody.auth.member.repository.CustomerJpaRepository;
import com.umc.foody.domain.review.dto.ReviewRequestDto;
import com.umc.foody.domain.review.entity.Review;
import com.umc.foody.domain.review.repository.ReviewJpaRepository;
import com.umc.foody.domain.reviewimage.entity.ReviewImage;
import com.umc.foody.domain.reviewimage.service.command.ReviewImageCommandService;
import com.umc.foody.domain.store.entity.Store;
import com.umc.foody.domain.store.repository.StoreJpaRepository;
import com.umc.foody.global.exception.common.code.ErrorStatus;
import com.umc.foody.global.exception.customer.CustomerException;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

	private final StoreJpaRepository storeJpaRepository;
	private final CustomerJpaRepository customerJpaRepository;
	private final ReviewImageCommandService reviewImageCommandService;
	private final ReviewJpaRepository reviewJpaRepository;

	@Override
	public Void createReview(ReviewRequestDto.CreateReview request,
		List<MultipartFile> images) {

		// 회원 검색
		Customer customer = customerJpaRepository.findById(request.getMemberId())
			.orElseThrow(() -> new CustomerException(ErrorStatus.MEMBER_NOT_FOUND));

		// 가게 검색
		Store store = storeJpaRepository.findById(request.getStoreId())
			.orElseThrow(() -> new CustomerException(ErrorStatus.STORE_NOT_FOUND));

		// 리뷰 이미지 업로드
		List<ReviewImage> uploadedImages = null;
		if (images != null) {
			uploadedImages = images.stream()
				.map(reviewImageCommandService::uploadAndCreateReviewImage)
				.collect(Collectors.toList());
		}

		Review review = Review.createReview(customer, store, request.getContent(), request.getRating(), uploadedImages);

		reviewJpaRepository.save(review);

		return null;
	}
}
