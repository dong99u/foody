package com.umc.foody.domain.store.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.umc.foody.domain.review.dto.ReviewResponseDto;
import com.umc.foody.domain.store.service.query.StoreQueryService;
import com.umc.foody.global.common.CommonResponse;
import com.umc.foody.global.validation.annotation.ExistsStoreId;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/stores")
@Validated
public class StoreV1Controller {

	private final StoreQueryService storeQueryService;

	@GetMapping("/{storeId}/reviews")
	@Operation(summary = "특정 가게의 리뷰 목록 조회 API", description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
	@ApiResponses({
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
	})
	@Parameters({
		@Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!")
	})

	public CommonResponse<ReviewResponseDto.ReviewsResponse> getReviews(@ExistsStoreId @PathVariable Long storeId,
		@RequestParam(required = false) Integer page,
		@RequestParam(defaultValue = "10") Integer size) {
		return CommonResponse.onSuccess(storeQueryService.getReviews(storeId, page, size));
	}
}
