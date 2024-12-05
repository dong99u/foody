package com.umc.foody.domain.foodcategory.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.umc.foody.auth.member.entity.Customer;
import com.umc.foody.global.common.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
public class FavoriteFoodCategory extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "favorite_food_category_id")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "food_category_id")
	private FoodCategory foodCategory;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Customer customer;

	public static FavoriteFoodCategory createFavoriteFoodCategory(FoodCategory foodCategory, Customer customer) {
		FavoriteFoodCategory favoriteFoodCategory = FavoriteFoodCategory.builder()
			.foodCategory(foodCategory)
			.customer(customer)
			.build();

		customer.addFavoriteFoodCategory(favoriteFoodCategory);
		return favoriteFoodCategory;
	}

}
