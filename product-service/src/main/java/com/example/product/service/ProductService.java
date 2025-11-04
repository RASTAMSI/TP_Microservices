package com.example.product.service;

import com.example.product.dao.ProductRepository;
import com.example.product.domain.Product;
import com.example.product.exceptions.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) { this.repo = repo; }

    public Product save(Product p) { return repo.save(p); }

    public List<Product> findAll() { return repo.findAll(); }

    public Product findById(Long id) {
        return repo.findById(id).orElseThrow(
                () -> new ProductNotFoundException("Produit introuvable : " + id));
    }

    public void delete(Long id) { repo.deleteById(id); }
}
