package com.umc.foody.auth.member.dto;

import java.time.LocalDateTime;

import com.umc.foody.auth.member.entity.Customer;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CustomerResponseDTO {

	@Getter
	@Builder
	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	@AllArgsConstructor
	public static class JoinDTO {
		Long id;

		LocalDateTime createdAt;

		public static CustomerResponseDTO.JoinDTO from(Customer customer) {
			return CustomerResponseDTO.JoinDTO.builder()
				.id(customer.getId())
				.createdAt(customer.getCreatedAt())
				.build();
		}

	}

}
