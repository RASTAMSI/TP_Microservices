package com.example.recommendation.controller;

import com.example.recommendation.domain.Recommendation;
import com.example.recommendation.dto.RecommendationDto;
import com.example.recommendation.service.RecommendationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recommendations")
public class RecommendationController {

    private final RecommendationService service;

    public RecommendationController(RecommendationService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<RecommendationDto> create(@Valid @RequestBody RecommendationDto dto) {
        Recommendation r = new Recommendation();
        r.setId(dto.id());
        r.setProductId(dto.productId());
        r.setAuthor(dto.author());
        r.setContent(dto.content());
        r.setRate(dto.rate());
        service.save(r);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/product/{productId}")
    public List<RecommendationDto> listByProduct(@PathVariable Long productId) {
        return service.findByProduct(productId).stream()
                .map(r -> new RecommendationDto(r.getId(), r.getProductId(), r.getAuthor(), r.getContent(), r.getRate()))
                .toList();
    }
}
