package com.umc.foody.domain.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.umc.foody.domain.review.entity.Review;

@Repository
public interface ReviewJpaRepository extends JpaRepository<Review, Long> {
	
}
