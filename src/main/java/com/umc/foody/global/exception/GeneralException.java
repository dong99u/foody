package com.umc.foody.global.exception;

import com.umc.foody.global.exception.code.BaseErrorCode;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {

	private final BaseErrorCode code;

	public ErrorReason getErrorReason() {
		return code.getReason();
	}

	public ErrorReason getErrorReasonHttpStatus() {
		return code.getReasonHttpStatus();
	}
}