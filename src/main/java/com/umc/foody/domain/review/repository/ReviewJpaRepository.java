package com.umc.foody.domain.review.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.umc.foody.domain.review.entity.Review;

@Repository
public interface ReviewJpaRepository extends JpaRepository<Review, Long> {

	@Query("SELECT r FROM Review r "
		+ "JOIN FETCH r.store "
		+ "JOIN FETCH r.customer "
		+ "WHERE r.store.id = :storeId")
	Page<Review> findReviewsAndStoresAndCustomersByStoreId(@Param("storeId") Long storeId, Pageable pageable);
}
