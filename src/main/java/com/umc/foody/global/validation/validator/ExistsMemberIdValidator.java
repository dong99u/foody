package com.umc.foody.global.validation.validator;

import org.springframework.stereotype.Component;

import com.umc.foody.auth.member.repository.MemberJpaRepository;
import com.umc.foody.global.exception.common.code.ErrorStatus;
import com.umc.foody.global.validation.annotation.ExistsMemberId;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ExistsMemberIdValidator implements ConstraintValidator<ExistsMemberId, Long> {

	private final MemberJpaRepository memberJpaRepository;

	@Override
	public void initialize(ExistsMemberId constraintAnnotation) {
		ConstraintValidator.super.initialize(constraintAnnotation);
	}

	@Override
	public boolean isValid(Long value, ConstraintValidatorContext context) {
		boolean isValid = memberJpaRepository.existsById(value);

		if (!isValid) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(ErrorStatus.MEMBER_NOT_FOUND.getMessage())
				.addConstraintViolation();
		}

		return isValid;
	}
}
