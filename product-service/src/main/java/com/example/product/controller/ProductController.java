package com.example.product.controller;

import com.example.product.domain.Product;
import com.example.product.dto.ProductDto;
import com.example.product.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<ProductDto> create(@Valid @RequestBody ProductDto dto) {
        Product p = new Product();
        p.setId(dto.id());
        p.setName(dto.name());
        p.setDescription(dto.description());
        p.setPrice(dto.price());
        p.setWeight(dto.weight());
        Product saved = service.save(p);
        return ResponseEntity.ok(new ProductDto(saved.getId(), saved.getName(),
                saved.getDescription(), saved.getPrice(), saved.getWeight()));
    }

    @GetMapping
    public List<ProductDto> list() {
        return service.findAll().stream()
                .map(p -> new ProductDto(p.getId(), p.getName(), p.getDescription(), p.getPrice(), p.getWeight()))
                .toList();
    }

    @GetMapping("/{id}")
    public ProductDto get(@PathVariable Long id) {
        Product p = service.findById(id);
        return new ProductDto(p.getId(), p.getName(), p.getDescription(), p.getPrice(), p.getWeight());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
