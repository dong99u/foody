package com.umc.foody.auth.member.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Address {
	// 시/도 (예: 서울특별시, 경기도)
	@Column(nullable = false, length = 50)
	private String province;

	// 시/군/구 (예: 강남구, 성남시)
	@Column(nullable = false, length = 50)
	private String city;

	// 도로명 (예: 테헤란로 231)
	@Column(nullable = false, length = 50)
	private String street;

	// 상세주소 (예: 101동 1502호)
	@Column(nullable = false, length = 50)
	private String detail;

	// 우편번호
	@Column(nullable = false, length = 10)
	private String zipcode;
}
