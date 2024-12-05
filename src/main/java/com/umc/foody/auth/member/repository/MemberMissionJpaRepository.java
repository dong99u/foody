package com.umc.foody.auth.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.umc.foody.domain.mission.entity.MemberMission;

@Repository
public interface MemberMissionJpaRepository extends JpaRepository<MemberMission, Long> {
}
