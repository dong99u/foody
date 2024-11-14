package com.umc.foody.auth.member.repository;

import static com.umc.foody.auth.member.entity.QMember.*;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.umc.foody.auth.member.entity.Member;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {

	private final JPAQueryFactory jpaQueryFactory;
	private final BooleanBuilder booleanBuilder = new BooleanBuilder();

	@Override
	public List<Member> dynamicQueryWithBooleanBuilder(String name) {
		if (name != null) {
			booleanBuilder.and(member.name.eq(name));
		}

		return jpaQueryFactory
			.selectFrom(member)
			.where(booleanBuilder)
			.fetch();

	}
}
