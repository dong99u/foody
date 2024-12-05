package com.umc.foody.domain.review.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.umc.foody.auth.member.entity.Customer;
import com.umc.foody.domain.comment.entity.Comment;
import com.umc.foody.domain.reviewimage.entity.ReviewImage;
import com.umc.foody.domain.store.entity.Store;
import com.umc.foody.global.common.BaseEntity;
import com.umc.foody.global.exception.common.code.ErrorStatus;
import com.umc.foody.global.exception.review.ReviewException;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
public class Review extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "review_id")
	private Long id;

	@Lob
	private String content;

	private Double rating;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "store_id")
	private Store store;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@OneToMany(mappedBy = "review", orphanRemoval = true, cascade = CascadeType.ALL)
	@Builder.Default
	private List<ReviewImage> reviewImages = new ArrayList<>(); // 리뷰 이미지

	@OneToMany(mappedBy = "review", orphanRemoval = true, cascade = CascadeType.ALL)
	@Builder.Default
	private List<Comment> comments = new ArrayList<>(); // 댓글

	//==생성 메서드==//
	public static Review createReview(Customer customer, Store store, String content, Double rating,
		List<ReviewImage> reviewImages) {
		validateRating(rating);
		validateContent(content);

		Review newReview = Review.builder()
			.content(content)
			.rating(rating)
			.build();

		newReview.setCustomer(customer);
		newReview.setStore(store);

		if (reviewImages != null && !reviewImages.isEmpty()) {
			reviewImages.forEach(newReview::addReviewImage);
		}

		return newReview;

	}

	private static void validateContent(String content) {
		if (content.length() > 1000) {
			throw new ReviewException(ErrorStatus.CONTENT_LENGTH_EXCEEDED);
		}
	}

	private static void validateRating(Double rating) {
		if (rating < 0 || rating > 5) {
			throw new ReviewException(ErrorStatus.RATING_OUT_OF_RANGE);
		}
	}

	private void addReviewImage(ReviewImage reviewImage) {
		this.reviewImages.add(reviewImage);
		reviewImage.setReview(this);
	}

	private void setStore(Store store) {
		this.store = store;
		store.getReviews().add(this);
	}

	private void setCustomer(Customer customer) {
		this.customer = customer;
		customer.getReviews().add(this);
	}

}
