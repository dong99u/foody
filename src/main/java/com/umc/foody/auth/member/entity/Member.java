package com.umc.foody.auth.member.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.umc.foody.global.common.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
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
@Inheritance(strategy = InheritanceType.JOINED)  // 상속 관계 매핑 전략 지정
@DiscriminatorColumn(name = "member_type")  // 부모 클래스에 구분 컬럼을 지정
public abstract class Member extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "member_id")
	private Long id;

	private String name;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	private String phoneNumber;

	private LocalDate birthDate;

	@Embedded
	private Address address;

	private LocalDateTime inactivatedAt;

	@Builder.Default
	private Boolean isDeleted = false;

	// 모든 회원 타입이 구현해야 하는 메서드
	public abstract void deactivate();

	// 공통 구현이 가능한 메서드는 구체적으로 구현
	public boolean isActive() {
		return this.inactivatedAt == null && !this.isDeleted;
	}

	protected void setInactivatedAt(LocalDateTime inactivatedAt) {
		this.inactivatedAt = inactivatedAt;
	}

	protected void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

}
