package com.umc.foody.global.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonPropertyOrder("isSuccess, code, message, data")
public class CommonResponse<T> {

	@JsonProperty("isSuccess")
	private Boolean isSuccess;

	@JsonProperty("code")
	private String code;

	@JsonProperty("message")
	private String message;

	@JsonProperty("data")
	private T data;

	// 성공한 경우 응답 생성

	//    public static <T> ApiResponse<T> onSuccess(T data){
	//        return new ApiResponse<>(true, SuccessStatus._OK.getCode() , SuccessStatus._OK.getMessage(), data);
	//    }
	//
	//    public static <T> ApiResponse<T> of(BaseCode code, T result){
	//        return new ApiResponse<>(true, code.getReasonHttpStatus().getCode() , code.getReasonHttpStatus().getMessage(), result);
	//    }

	// 실패할 경우
	public static <T> CommonResponse<T> onFailure(String code, String message, T data) {
		return new CommonResponse<>(false, code, message, data);
	}
}
