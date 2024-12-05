package com.umc.foody.domain.review.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.umc.foody.domain.review.dto.ReviewRequestDto;
import com.umc.foody.domain.review.service.command.ReviewCommandService;
import com.umc.foody.global.common.CommonResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/reviews")
@RequiredArgsConstructor
public class ReviewV1Controller {

	private final ReviewCommandService reviewCommandService;

	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public CommonResponse<Void> createReview(
		@Valid @RequestPart(value = "request") ReviewRequestDto.CreateReview request,
		@RequestPart(value = "images", required = false) List<MultipartFile> images
	) {

		return CommonResponse.onSuccess(reviewCommandService.createReview(request, images));

	}
}
