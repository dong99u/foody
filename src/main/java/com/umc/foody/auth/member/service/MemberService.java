package com.umc.foody.auth.member.service;

import java.util.List;
import java.util.Optional;

import com.umc.foody.auth.member.entity.Member;

public interface MemberService {

	Optional<Member> findById(Long id);
	
	List<Member> findMemberByName(String name);
}
