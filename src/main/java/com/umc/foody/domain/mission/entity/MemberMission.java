package com.umc.foody.domain.mission.entity;

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
@DynamicUpdate
@DynamicInsert
public class MemberMission extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "member_mission_id")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Customer customer; // 회원

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mission_id")
	private Mission mission; // 미션

	private MissionStatus status; // 미션 상태

	//==생성 메서드==//
	public static MemberMission createMemberMission(Customer customer, Mission mission) {
		MemberMission newMemberMission = MemberMission.builder()
			.customer(customer)
			.mission(mission)
			.status(MissionStatus.PROGRESS)
			.build();

		// Member와 MemberMission 연관관계 매핑
		newMemberMission.setCustomer(customer);

		newMemberMission.setMission(mission);

		return newMemberMission;

	}

	private void setCustomer(Customer customer) {
		this.customer = customer;
		customer.getMemberMissions().add(this);
	}

	private void setMission(Mission mission) {
		this.mission = mission;
		mission.getMemberMissions().add(this);
	}
}
