package com.umc.foody.auth.member.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.umc.foody.domain.alarm.entity.Alarm;
import com.umc.foody.domain.foodcategory.entity.FavoriteFoodCategory;
import com.umc.foody.domain.mission.entity.MemberMission;
import com.umc.foody.domain.review.entity.Review;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@Entity
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@DynamicUpdate
@DynamicInsert
@DiscriminatorValue("CUSTOMER")
public class Customer extends Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private Long id;

	@Column(nullable = false)
	@Builder.Default
	@ColumnDefault("0")
	private Integer points = 0; // 포인트

	@OneToMany(mappedBy = "customer", orphanRemoval = true, cascade = CascadeType.ALL)
	@Builder.Default
	private List<MemberMission> memberMissions = new ArrayList<>(); // 회원 미션

	@OneToMany(mappedBy = "customer", orphanRemoval = true, cascade = CascadeType.ALL)
	@Builder.Default
	private List<Review> reviews = new ArrayList<>(); // 리뷰

	@OneToMany(mappedBy = "customer", orphanRemoval = true, cascade = CascadeType.ALL)
	@Builder.Default
	private List<FavoriteFoodCategory> favoriteFoodCategories = new ArrayList<>(); // 즐겨찾는 음식 카테고리

	@OneToMany(mappedBy = "customer", orphanRemoval = true, cascade = CascadeType.ALL)
	@Builder.Default
	private List<Alarm> alarms = new ArrayList<>(); // 알람


	/*
	 * 편의 메서드
	 * */

	/**
	 * 회원 생성
	 * @param name
	 * @param gender
	 * @param birthDate
	 * @param address
	 * @param favoriteFoodCategories
	 * @return
	 */
	public static Customer createCustomer(String name, Gender gender, LocalDate birthDate, Address address) {
		return Customer.builder()
			.name(name)
			.gender(gender)
			.birthDate(birthDate)
			.address(address)
			.build();
	}

	public void addFavoriteFoodCategory(FavoriteFoodCategory favoriteFoodCategory) {
		this.favoriteFoodCategories.add(favoriteFoodCategory);
	}

	@Override
	public void deactivate() {
		this.points = 0;  // 포인트 소멸
		setInactivatedAt(LocalDateTime.now());
		setIsDeleted(true);
	}

	public void addReview(Review review) {
		this.reviews.add(review);
	}

}
