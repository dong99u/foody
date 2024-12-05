package com.umc.foody.global.exception.foodcategory;

import com.umc.foody.global.exception.common.GeneralException;
import com.umc.foody.global.exception.common.code.BaseErrorCode;

public class FoodCategoryException extends GeneralException {

	public FoodCategoryException(BaseErrorCode code) {
		super(code);
	}
}
