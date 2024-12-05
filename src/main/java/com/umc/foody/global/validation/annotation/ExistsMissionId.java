package com.umc.foody.global.validation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.umc.foody.global.validation.validator.ExistsMissionIdValidator;

import jakarta.validation.Constraint;

@Documented
@Constraint(validatedBy = ExistsMissionIdValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistsMissionId {
}
