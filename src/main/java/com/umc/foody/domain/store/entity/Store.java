package com.umc.foody.domain.store.entity;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.umc.foody.auth.member.entity.Address;
import com.umc.foody.auth.member.entity.StoreOwner;
import com.umc.foody.domain.mission.entity.Mission;
import com.umc.foody.domain.review.entity.Review;
import com.umc.foody.global.common.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@DynamicUpdate
@DynamicInsert
public class Store extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "store_id")
	private Long id;

	private String name;

	@Embedded
	private Address address;

	private String phoneNumber;

	private LocalTime openTime;

	private LocalTime closeTime;

	@Builder.Default
	private Double rating = 0.0;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "store_owner_id")
	private StoreOwner storeOwner;

	@OneToMany(mappedBy = "store", orphanRemoval = true, cascade = CascadeType.ALL)
	@Builder.Default
	private List<Review> reviews = new ArrayList<>();

	@OneToMany(mappedBy = "store", orphanRemoval = true, cascade = CascadeType.ALL)
	@Builder.Default
	private List<Mission> missions = new ArrayList<>();

}
