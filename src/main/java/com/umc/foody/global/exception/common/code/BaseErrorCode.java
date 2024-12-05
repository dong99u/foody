package com.umc.foody.global.exception.common.code;

import com.umc.foody.global.exception.common.ErrorReason;

public interface BaseErrorCode {

	ErrorReason getReason();

	ErrorReason getReasonHttpStatus();

}