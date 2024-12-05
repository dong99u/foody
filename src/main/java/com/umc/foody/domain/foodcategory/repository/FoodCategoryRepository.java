package com.umc.foody.domain.foodcategory.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.umc.foody.domain.foodcategory.entity.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {

	Optional<FoodCategory> findByName(String name);

	boolean existsByName(String category);

	List<FoodCategory> findAllByNameIn(List<String> categoryNames);
}
