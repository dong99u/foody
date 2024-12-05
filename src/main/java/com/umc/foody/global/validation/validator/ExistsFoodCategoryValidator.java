package com.umc.foody.global.validation.validator;

import java.util.List;

import org.springframework.stereotype.Component;

import com.umc.foody.domain.foodcategory.service.query.FoodCategoryQueryService;
import com.umc.foody.global.exception.common.code.ErrorStatus;
import com.umc.foody.global.validation.annotation.ExistsFoodCategory;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ExistsFoodCategoryValidator implements ConstraintValidator<ExistsFoodCategory, List<String>> {

	private final FoodCategoryQueryService foodCategoryQueryService;

	@Override
	public boolean isValid(List<String> categoryNames, ConstraintValidatorContext context) {
		// null이나 빈 리스트에 대한 처리는 다른 검증 어노테이션으로 위임합니다
		if (categoryNames == null || categoryNames.isEmpty()) {
			return true;
		}

		// 서비스 계층을 통해 카테고리 이름의 존재 여부를 확인합니다
		boolean isValid = foodCategoryQueryService.existsAllByNames(categoryNames);

		// 유효하지 않은 경우, 적절한 에러 메시지를 설정합니다
		if (!isValid) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(
				ErrorStatus.FOOD_CATEGORY_NOT_FOUND.toString()
			).addConstraintViolation();
		}

		return isValid;
	}

	@Override
	public void initialize(ExistsFoodCategory constraintAnnotation) {
		ConstraintValidator.super.initialize(constraintAnnotation);
	}

}
