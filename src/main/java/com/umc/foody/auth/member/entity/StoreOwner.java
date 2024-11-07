package com.umc.foody.auth.member.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.umc.foody.domain.store.entity.Store;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Embedded;
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
@DiscriminatorValue("STORE_OWNER")
public class StoreOwner extends Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "store_owner_id")
	private Long id;

	private String storeName;

	@Embedded
	private Address storeAddress;

	private String storePhoneNumber;

	@OneToMany(mappedBy = "storeOwner")
	@Builder.Default
	private List<Store> stores = new ArrayList<>();

	@Override
	public void deactivate() {
		setInactivatedAt(null);
		setIsDeleted(true);
	}
}
