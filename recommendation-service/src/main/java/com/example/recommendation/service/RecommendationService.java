package com.example.recommendation.service;

import com.example.recommendation.dao.RecommendationRepository;
import com.example.recommendation.domain.Recommendation;
import com.example.recommendation.exceptions.RecommendationNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationService {

    private final RecommendationRepository repo;

    public RecommendationService(RecommendationRepository repo) { this.repo = repo; }

    public Recommendation save(Recommendation r) { return repo.save(r); }

    public List<Recommendation> findByProduct(Long productId) {
        return repo.findByProductId(productId);
    }

    public Recommendation findById(Long id) {
        return repo.findById(id).orElseThrow(
                () -> new RecommendationNotFoundException("Recommandation introuvable : " + id)
        );
    }

    public void delete(Long id) { repo.deleteById(id); }
}
