package com.umc.foody.domain.foodcategory.service.query;

import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.umc.foody.domain.foodcategory.entity.FoodCategory;
import com.umc.foody.domain.foodcategory.repository.FoodCategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FoodCategoryQueryServiceImpl implements FoodCategoryQueryService {

	private final FoodCategoryRepository foodCategoryRepository;

	@Override
	public boolean existsAllByNames(List<String> categoryNames) {
		// 하나의 쿼리로 모든 카테고리 이름을 검증합니다
		List<String> existingNames = foodCategoryRepository.findAllByNameIn(categoryNames)
			.stream()
			.map(FoodCategory::getName)
			.toList();

		// 모든 요청된 카테고리 이름이 존재하는지 확인합니다
		return existingNames.size() == categoryNames.size() &&
			new HashSet<>(existingNames).containsAll(categoryNames);

	}

}
