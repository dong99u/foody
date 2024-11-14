package com.umc.foody.auth.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.umc.foody.auth.member.entity.Member;

@Repository
public interface MemberJpaRepository extends JpaRepository<Member, Long> {
	
}
