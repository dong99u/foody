package com.umc.foody.global.exception.customer;

import com.umc.foody.global.exception.common.GeneralException;
import com.umc.foody.global.exception.common.code.BaseErrorCode;

public class CustomerException extends GeneralException {

	public CustomerException(BaseErrorCode code) {
		super(code);
	}
}
