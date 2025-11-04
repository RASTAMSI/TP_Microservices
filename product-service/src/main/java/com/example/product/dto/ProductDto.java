package com.example.product.dto;

public record ProductDto(
        Long id,
        String name,
        String description,
        Double price,
        Double weight
) {}
