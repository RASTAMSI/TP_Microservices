package com.example.review.controller;

import com.example.review.domain.Review;
import com.example.review.dto.ReviewDto;
import com.example.review.service.ReviewService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService service;

    public ReviewController(ReviewService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<ReviewDto> create(@Valid @RequestBody ReviewDto dto) {
        Review r = new Review();
        r.setId(dto.id());
        r.setProductId(dto.productId());
        r.setAuthor(dto.author());
        r.setSubject(dto.subject());
        r.setContent(dto.content());
        r.setRating(dto.rating());
        Review saved = service.save(r);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/product/{productId}")
    public List<ReviewDto> listByProduct(@PathVariable Long productId) {
        return service.findByProduct(productId).stream()
                .map(r -> new ReviewDto(r.getId(), r.getProductId(), r.getAuthor(), r.getSubject(), r.getContent(), r.getRating()))
                .toList();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
