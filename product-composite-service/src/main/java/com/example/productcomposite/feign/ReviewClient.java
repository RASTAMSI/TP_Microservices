package com.example.productcomposite.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@FeignClient(name = "review-service")
public interface ReviewClient {

    @GetMapping("/reviews/product/{productId}")
    List<Map<String, Object>> getReviews(@PathVariable("productId") Long productId);
}
