package com.umc.foody.global.exception.code;

import com.umc.foody.global.exception.ErrorReason;

public interface BaseErrorCode {

	ErrorReason getReason();

	ErrorReason getReasonHttpStatus();

}


