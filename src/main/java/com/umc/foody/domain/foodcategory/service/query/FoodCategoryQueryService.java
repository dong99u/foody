package com.umc.foody.domain.foodcategory.service.query;

import java.util.List;

public interface FoodCategoryQueryService {
	boolean existsAllByNames(List<String> names);
}
