package com.umc.foody.global.validation.validator;

import org.springframework.stereotype.Component;

import com.umc.foody.domain.store.repository.StoreJpaRepository;
import com.umc.foody.global.exception.common.code.ErrorStatus;
import com.umc.foody.global.validation.annotation.ExistsStoreId;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ExistsStoreIdValidator implements ConstraintValidator<ExistsStoreId, Long> {

	private final StoreJpaRepository storeJpaRepository;

	@Override
	public void initialize(ExistsStoreId constraintAnnotation) {
		ConstraintValidator.super.initialize(constraintAnnotation);
	}

	@Override
	public boolean isValid(Long storeId, ConstraintValidatorContext context) {
		boolean isValid = storeJpaRepository.existsById(storeId);

		if (!isValid) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(ErrorStatus.STORE_NOT_FOUND.getMessage())
				.addConstraintViolation();
		}

		return isValid;
	}
}
