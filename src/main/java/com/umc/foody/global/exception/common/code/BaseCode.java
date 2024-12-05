package com.umc.foody.global.exception.common.code;

import com.umc.foody.global.exception.common.Reason;

public interface BaseCode {
	Reason getReason();

	Reason getReasonHttpStatus();
}
