package com.example.productcomposite.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@FeignClient(name = "product-service")
public interface ProductClient {

    @GetMapping("/products/{id}")
    Map<String, Object> getProduct(@PathVariable("id") Long id);
}
