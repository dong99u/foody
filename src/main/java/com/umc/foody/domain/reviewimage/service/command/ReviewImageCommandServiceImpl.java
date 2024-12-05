package com.umc.foody.domain.reviewimage.service.command;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.umc.foody.domain.reviewimage.entity.ReviewImage;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewImageCommandServiceImpl implements ReviewImageCommandService {
	@Override
	public ReviewImage uploadAndCreateReviewImage(MultipartFile image) {
		// s3로 이미지를 저장하고 url을 받아들임.
		String uploadedImageUrl = uploadImageToS3(image);

		// ReviewImage 생성
		return ReviewImage.createReviewImage(uploadedImageUrl);

	}

	// s3로 이미지를 저장하고 url을 받아들이는 로직
	private String uploadImageToS3(MultipartFile imageFile) {
		return null;
	}
}

