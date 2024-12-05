package com.umc.foody.domain.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.umc.foody.domain.store.entity.Store;

public interface StoreJpaRepository extends JpaRepository<Store, Long> {

}
