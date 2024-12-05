package com.umc.foody.global.exception.common;

import com.umc.foody.global.exception.common.code.BaseErrorCode;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {

	private final BaseErrorCode code;

	public ErrorReason getErrorReason() {
		return this.code.getReason();
	}

	public ErrorReason getErrorReasonHttpStatus() {
		return this.code.getReasonHttpStatus();
	}

}