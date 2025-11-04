package com.example.review.dto;

public record ReviewDto(
        Long id,
        Long productId,
        String author,
        String subject,
        String content,
        Integer rating
) {}
