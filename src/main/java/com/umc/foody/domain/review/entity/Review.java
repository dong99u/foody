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

}
