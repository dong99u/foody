package com.umc.foody.domain.store.repository;

import static com.umc.foody.domain.store.entity.QStore.*;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.umc.foody.domain.store.entity.Store;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class StoreRepositoryImpl implements StoreRepository {

	private final JPAQueryFactory jpaQueryFactory;

	@Override
	public Optional<Store> findById(Long id) {
		return Optional.ofNullable(
			jpaQueryFactory
				.selectFrom(store)
				.where(store.id.eq(id))
				.fetchOne()
		);
	}
}
