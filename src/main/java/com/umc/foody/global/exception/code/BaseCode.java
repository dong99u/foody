package com.umc.foody.global.exception.code;

import com.umc.foody.global.exception.Reason;

public interface BaseCode {

	Reason getReason();

	Reason getReasonHttpStatus();

}
