package com.umc.foody.domain.store.repository;

import java.util.Optional;

import com.umc.foody.domain.store.entity.Store;

public interface StoreRepository {

	Optional<Store> findById(Long id);
}
