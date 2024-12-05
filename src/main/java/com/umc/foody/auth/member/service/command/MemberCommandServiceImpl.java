package com.umc.foody.auth.member.service.command;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.umc.foody.auth.member.dto.CustomerRequestDTO;
import com.umc.foody.auth.member.dto.CustomerResponseDTO;
import com.umc.foody.auth.member.entity.Address;
import com.umc.foody.auth.member.entity.Customer;
import com.umc.foody.auth.member.entity.Member;
import com.umc.foody.auth.member.repository.CustomerJpaRepository;
import com.umc.foody.auth.member.repository.MemberJpaRepository;
import com.umc.foody.auth.member.repository.MemberMissionJpaRepository;
import com.umc.foody.auth.member.repository.MemberRepository;
import com.umc.foody.domain.foodcategory.entity.FavoriteFoodCategory;
import com.umc.foody.domain.foodcategory.entity.FoodCategory;
import com.umc.foody.domain.foodcategory.repository.FoodCategoryRepository;
import com.umc.foody.domain.mission.entity.MemberMission;
import com.umc.foody.domain.mission.entity.Mission;
import com.umc.foody.domain.mission.repository.MemberMissionRepositoryImpl;
import com.umc.foody.domain.mission.repository.MissionJpaRepository;
import com.umc.foody.global.exception.common.code.ErrorStatus;
import com.umc.foody.global.exception.customer.CustomerException;
import com.umc.foody.global.exception.foodcategory.FoodCategoryException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberCommandServiceImpl implements MemberCommandService {

	private final MemberRepository memberRepository;
	private final MemberJpaRepository memberJpaRepository;
	private final FoodCategoryRepository foodCategoryRepository;
	private final MissionJpaRepository missionJpaRepository;
	private final CustomerJpaRepository customerJpaRepository;
	private final MemberMissionRepositoryImpl memberMissionRepositoryImpl;
	private final MemberMissionJpaRepository memberMissionJpaRepository;

	@Override
	public Optional<Member> findById(Long id) {
		return memberJpaRepository.findById(id);
	}

	@Override
	public List<Member> findMemberByName(String name) {

		return memberRepository.dynamicQueryWithBooleanBuilder(name);

	}

	@Override
	public CustomerResponseDTO.JoinDTO join(CustomerRequestDTO.JoinDTO joinDTO) {
		// 1. 주소 객체 생성
		Address address = Address.createAddress(
			joinDTO.getAddressDTO().getProvince(),
			joinDTO.getAddressDTO().getCity(),
			joinDTO.getAddressDTO().getStreet(),
			joinDTO.getAddressDTO().getDetail(),
			joinDTO.getAddressDTO().getZipcode()
		);

		// 2. Customer 엔티티 생성
		Customer customer = Customer.createCustomer(
			joinDTO.getName(),
			joinDTO.getGender(),
			joinDTO.getBirthDate(),
			address
		);

		// 3. 선호하는 음식 카테고리 처리
		if (joinDTO.getFavoriteFoodCategoryNames() != null && !joinDTO.getFavoriteFoodCategoryNames().isEmpty()) {
			joinDTO.getFavoriteFoodCategoryNames().forEach(categoryName -> {
				FoodCategory foodCategory = foodCategoryRepository.findByName(categoryName)
					.orElseThrow(() -> new FoodCategoryException(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));

				FavoriteFoodCategory.createFavoriteFoodCategory(foodCategory, customer);
			});
		}

		// 4. Customer 저장
		Customer savedCustomer = memberJpaRepository.save(customer);

		return CustomerResponseDTO.JoinDTO.from(savedCustomer);
	}

	@Override
	public Void addMission(CustomerRequestDTO.AddMissionDTO addMissionDTO) {
		// 1. 회원 조회
		Customer customer = customerJpaRepository.findById(addMissionDTO.getMemberId())
			.orElseThrow(() -> new CustomerException(ErrorStatus.MEMBER_NOT_FOUND));

		// 2. 미션 조회
		Mission selectedMission = missionJpaRepository.findById(addMissionDTO.getMissionId())
			.orElseThrow(() -> new CustomerException(ErrorStatus.MISSION_NOT_FOUND));

		// 3. 미션 추가
		MemberMission newMemberMission = MemberMission.createMemberMission(customer, selectedMission);

		return null;
	}
}


