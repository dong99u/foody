package com.umc.foody.domain.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.umc.foody.domain.store.entity.Store;

@Repository
public interface StoreJpaRepository extends JpaRepository<Store, Long> {
}
