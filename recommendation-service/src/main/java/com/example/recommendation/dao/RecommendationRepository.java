package com.example.recommendation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.recommendation.domain.Recommendation;

import java.util.List;

public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {
    List<Recommendation> findByProductId(Long productId);
}
