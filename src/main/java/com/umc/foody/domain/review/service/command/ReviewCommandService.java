package com.umc.foody.domain.review.service.command;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.umc.foody.domain.review.dto.ReviewRequestDto;

public interface ReviewCommandService {

	Void createReview(ReviewRequestDto.CreateReview request, List<MultipartFile> images);

}
