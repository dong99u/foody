package com.umc.foody.auth.member.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.umc.foody.auth.member.dto.CustomerRequestDTO;
import com.umc.foody.auth.member.dto.CustomerResponseDTO;
import com.umc.foody.auth.member.service.command.MemberCommandService;
import com.umc.foody.global.common.CommonResponse;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Tag(name = "회원 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
public class MemberV1Controller {

	private final MemberCommandService memberCommandService;

	@PostMapping("/join")
	public CommonResponse<CustomerResponseDTO.JoinDTO> join(@RequestBody @Valid CustomerRequestDTO.JoinDTO joinDTO) {
		return null;
	}
}
