package com.umc.foody.domain.reviewimage.service.command;

import org.springframework.web.multipart.MultipartFile;

import com.umc.foody.domain.reviewimage.entity.ReviewImage;

public interface ReviewImageCommandService {
	ReviewImage uploadAndCreateReviewImage(MultipartFile image);
}
