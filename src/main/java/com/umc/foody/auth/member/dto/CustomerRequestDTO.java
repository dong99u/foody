package com.umc.foody.auth.member.dto;

import java.time.LocalDate;
import java.util.List;

import com.umc.foody.auth.member.entity.Gender;
import com.umc.foody.global.validation.annotation.ExistsFoodCategory;
import com.umc.foody.global.validation.annotation.ExistsMemberId;
import com.umc.foody.global.validation.annotation.ExistsMissionId;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CustomerRequestDTO {

	/**
	 * 주소 DTO
	 */
	@Getter
	@Builder
	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	@AllArgsConstructor
	public static class AddressDTO {
		String province;
		String city;
		String street;
		String detail;
		String zipcode;

		public static AddressDTO createAddressDTO(String province, String city, String street, String detail,
			String zipcode) {
			return AddressDTO.builder()
				.province(province)
				.city(city)
				.street(street)
				.detail(detail)
				.zipcode(zipcode)
				.build();
		}

	}

	@Getter
	@Builder
	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	@AllArgsConstructor
	public static class JoinDTO {
		String name;

		Gender gender;

		LocalDate birthDate;

		AddressDTO addressDTO;

		@ExistsFoodCategory
		List<String> favoriteFoodCategoryNames;

	}

	@Getter
	@Builder
	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	@AllArgsConstructor
	public static class AddMissionDTO {

		@ExistsMissionId
		Long missionId;

		@ExistsMemberId
		Long memberId;

	}
}
