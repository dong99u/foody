package com.umc.foody.global.exception.store;

import com.umc.foody.global.exception.common.GeneralException;
import com.umc.foody.global.exception.common.code.BaseErrorCode;

public class StoreException extends GeneralException {

	public StoreException(BaseErrorCode code) {
		super(code);
	}
}
