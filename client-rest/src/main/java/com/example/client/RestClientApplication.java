package com.example.client;

import com.example.client.service.ProductCompositeClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RestClientApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(RestClientApplication.class, args);
        ProductCompositeClient client = context.getBean(ProductCompositeClient.class);
        //récupérer le produit 1
        client.getCompositeProduct(1L);
    }
}