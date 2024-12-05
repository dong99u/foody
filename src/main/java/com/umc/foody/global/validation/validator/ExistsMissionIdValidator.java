package com.umc.foody.global.validation.validator;

import org.springframework.stereotype.Component;

import com.umc.foody.domain.mission.repository.MissionJpaRepository;
import com.umc.foody.global.exception.common.code.ErrorStatus;
import com.umc.foody.global.validation.annotation.ExistsMissionId;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ExistsMissionIdValidator implements ConstraintValidator<ExistsMissionId, Long> {

	private final MissionJpaRepository missionJpaRepository;

	@Override
	public void initialize(ExistsMissionId constraintAnnotation) {
		ConstraintValidator.super.initialize(constraintAnnotation);
	}

	@Override
	public boolean isValid(Long value, ConstraintValidatorContext context) {
		boolean isValid = missionJpaRepository.existsById(value);

		if (!isValid) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(
				ErrorStatus.MISSION_NOT_FOUND.getMessage()
			).addConstraintViolation();
		}

		return isValid;
	}
}
