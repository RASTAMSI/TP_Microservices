package com.example.recommendation.dto;

public record RecommendationDto(
        Long id,
        Long productId,
        String author,
        String content,
        Integer rate
) {}
