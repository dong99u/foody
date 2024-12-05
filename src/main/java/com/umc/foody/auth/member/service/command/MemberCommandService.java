package com.umc.foody.auth.member.service.command;

import java.util.List;
import java.util.Optional;

import com.umc.foody.auth.member.dto.CustomerRequestDTO;
import com.umc.foody.auth.member.dto.CustomerResponseDTO;
import com.umc.foody.auth.member.entity.Member;

public interface MemberCommandService {

	Optional<Member> findById(Long id);

	List<Member> findMemberByName(String name);

	CustomerResponseDTO.JoinDTO join(CustomerRequestDTO.JoinDTO joinDTO);

	Void addMission(CustomerRequestDTO.AddMissionDTO addMissionDTO);

}
