package com.umc.foody.global.validation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.umc.foody.global.validation.validator.ExistsFoodCategoryValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = ExistsFoodCategoryValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistsFoodCategory {
	String message() default "존재하지 않는 음식 카테고리입니다";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
