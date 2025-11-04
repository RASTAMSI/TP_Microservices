package com.example.productcomposite.controller;

import com.example.productcomposite.dto.ProductCompositeDto;
import com.example.productcomposite.service.ProductCompositeService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/composite/products")
public class ProductCompositeController {

    private final ProductCompositeService service;
    private final Counter getCounter;
    private final Counter writeCounter;

    public ProductCompositeController(ProductCompositeService service, MeterRegistry registry) {
        this.service = service;
        this.getCounter = registry.counter("composite.requests.get");
        this.writeCounter = registry.counter("composite.requests.write");
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductCompositeDto> getComposite(@PathVariable Long id) {
        getCounter.increment();
        return ResponseEntity.ok(service.getComposite(id));
    }

    @PostMapping
    public ResponseEntity<Void> createComposite(@RequestBody ProductCompositeDto dto) {
        writeCounter.increment();
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateComposite(@PathVariable Long id, @RequestBody ProductCompositeDto dto) {
        writeCounter.increment();
        return ResponseEntity.ok().build();
    }
}