package com.example.productcomposite.dto;

import java.util.List;
import java.util.Map;

public record ProductCompositeDto(
        Map<String, Object> product,
        List<Map<String, Object>> reviews,
        List<Map<String, Object>> recommendations
) {
}
