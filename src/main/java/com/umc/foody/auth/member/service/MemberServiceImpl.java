package com.umc.foody.auth.member.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.umc.foody.auth.member.entity.Member;
import com.umc.foody.auth.member.repository.MemberJpaRepository;
import com.umc.foody.auth.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

	private final MemberRepository memberRepository;
	private final MemberJpaRepository memberJpaRepository;

	@Override
	public Optional<Member> findById(Long id) {
		return memberJpaRepository.findById(id);
	}

	@Override
	public List<Member> findMemberByName(String name) {

		return memberRepository.dynamicQueryWithBooleanBuilder(name);

	}
}
