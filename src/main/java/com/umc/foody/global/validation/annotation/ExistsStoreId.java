package com.umc.foody.global.validation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.umc.foody.global.validation.validator.ExistsStoreIdValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = ExistsStoreIdValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistsStoreId {

	String message() default "존재하지 않는 가게입니다.";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
