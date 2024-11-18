package com.umc.foody.global.exception;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Reason {
	private final Boolean isSuccess;
	private final String code;
	private final String message;
	private final Object data;
	private HttpStatus httpStatus;

}
