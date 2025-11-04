package com.example.review.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.review.domain.Review;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByProductId(Long productId);
}
