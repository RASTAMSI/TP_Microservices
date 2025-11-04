package com.example.review.service;

import com.example.review.dao.ReviewRepository;
import com.example.review.domain.Review;
import com.example.review.exceptions.ReviewNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository repo;

    public ReviewService(ReviewRepository repo) { this.repo = repo; }

    public Review save(Review r) { return repo.save(r); }

    public List<Review> findAll() { return repo.findAll(); }

    public Review findById(Long id) {
        return repo.findById(id).orElseThrow(
                () -> new ReviewNotFoundException("Review introuvable : " + id)
        );
    }

    public List<Review> findByProduct(Long productId) {
        return repo.findByProductId(productId);
    }

    public void delete(Long id) { repo.deleteById(id); }
}
