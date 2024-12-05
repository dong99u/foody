package com.umc.foody.auth.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.umc.foody.auth.member.entity.Customer;

public interface CustomerJpaRepository extends JpaRepository<Customer, Long> {
	
}
