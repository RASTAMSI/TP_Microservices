package com.example.client.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class ProductCompositeClient {

    private final RestTemplate restTemplate;

    public ProductCompositeClient() {
        this.restTemplate = new RestTemplate();
    }

    public void getCompositeProduct(Long productId) {
        // Headers d'authentification
        HttpHeaders headers = new HttpHeaders();
        headers.set("username", "user");
        headers.set("password", "userpass");
        headers.set("role", "USER");

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<Map> response = restTemplate.exchange(
                    "http://localhost:8080/composite/products/" + productId,
                    HttpMethod.GET,
                    entity,
                    Map.class
            );

            System.out.println("Résultat :");
            System.out.println(response.getBody());
        } catch (Exception e) {
            System.err.println("Erreur : " + e.getMessage());
        }
    }
}