package com.umc.foody.global.exception.common;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ErrorReason {

	private final boolean isSuccess;
	private final String code;
	private final String message;
	private HttpStatus httpStatus;
}