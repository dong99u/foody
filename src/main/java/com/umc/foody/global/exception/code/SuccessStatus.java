package com.umc.foody.global.exception.code;

import org.springframework.http.HttpStatus;

import com.umc.foody.global.exception.Reason;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SuccessStatus implements BaseCode {

	_OK(HttpStatus.OK, "COMMON200", "성공입니다."),
	;

	private final HttpStatus httpStatus;
	private final String code;
	private final String message;

	@Override
	public Reason getReason() {
		return Reason.builder()
			.isSuccess(true)
			.code(code)
			.message(message)
			.build();
	}

	@Override
	public Reason getReasonHttpStatus() {
		return Reason.builder()
			.isSuccess(true)
			.code(code)
			.message(message)
			.httpStatus(httpStatus)
			.build();
	}
}
