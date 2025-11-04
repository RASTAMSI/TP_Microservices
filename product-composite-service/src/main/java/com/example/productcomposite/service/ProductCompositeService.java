package com.example.productcomposite.service;

import com.example.productcomposite.dto.ProductCompositeDto;
import com.example.productcomposite.feign.ProductClient;
import com.example.productcomposite.feign.ReviewClient;
import com.example.productcomposite.feign.RecommendationClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.Map;

@Service
public class ProductCompositeService {

    private final ProductClient productClient;
    private final ReviewClient reviewClient;
    private final RecommendationClient recommendationClient;

    public ProductCompositeService(ProductClient p, ReviewClient r, RecommendationClient rec) {
        this.productClient = p;
        this.reviewClient = r;
        this.recommendationClient = rec;
    }

    @CircuitBreaker(name = "compositeCB", fallbackMethod = "fallback")
    public ProductCompositeDto getComposite(Long productId) {
        var product = productClient.getProduct(productId);
        var reviews = reviewClient.getReviews(productId);
        var recommendations = recommendationClient.getRecommendations(productId);
        return new ProductCompositeDto(product, reviews, recommendations);
    }

    public ProductCompositeDto fallback(Long productId, Throwable t) {
        return new ProductCompositeDto(
                (Map<String, Object>) Collections.singletonMap("message", (Object)"Service temporairement indisponible"),
                Collections.emptyList(),
                Collections.emptyList()
        );

    }
}
