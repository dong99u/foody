package com.umc.foody.auth.member.dto;

import java.time.LocalDate;
import java.util.List;

import com.umc.foody.auth.member.entity.Address;
import com.umc.foody.auth.member.entity.Gender;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CustomerRequestDTO {

	@Getter
	@Builder
	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	@AllArgsConstructor
	public static class CustomerJoinDTO {
		String name;

		Gender gender;

		LocalDate birthDate;

		Address address;

		List<String> preferCategories;

	}
}
