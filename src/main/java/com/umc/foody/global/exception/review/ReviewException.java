package com.umc.foody.global.exception.review;

import com.umc.foody.global.exception.common.GeneralException;
import com.umc.foody.global.exception.common.code.BaseErrorCode;

public class ReviewException extends GeneralException {

	public ReviewException(BaseErrorCode code) {
		super(code);
	}
}
