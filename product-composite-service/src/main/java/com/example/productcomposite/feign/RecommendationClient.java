package com.example.productcomposite.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@FeignClient(name = "recommendation-service")
public interface RecommendationClient {

    @GetMapping("/recommendations/product/{productId}")
    List<Map<String, Object>> getRecommendations(@PathVariable("productId") Long productId);
}
