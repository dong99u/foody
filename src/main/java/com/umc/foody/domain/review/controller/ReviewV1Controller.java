package com.umc.foody.domain.review.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.umc.foody.domain.review.dto.ReviewRequestDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/reviews")
@RequiredArgsConstructor
public class ReviewV1Controller {

	@PostMapping
	public ResponseEntity<String> createReview(@RequestBody ReviewRequestDto.CreateReview request) {

		return ResponseEntity.ok("OK");
	}
}
