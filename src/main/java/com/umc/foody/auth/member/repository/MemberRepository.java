package com.umc.foody.auth.member.repository;

import java.util.List;

import com.umc.foody.auth.member.entity.Member;

public interface MemberRepository {

	List<Member> dynamicQueryWithBooleanBuilder(String name);
}
