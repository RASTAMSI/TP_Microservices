package com.example.product.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "products")
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom est obligatoire")
    private String name;

    private String description;

    @PositiveOrZero(message = "Le prix ne peut pas être négatif")
    private Double price;

    @NotNull(message = "Le poids est obligatoire")
    @Min(value = 0, message = "Poids min = 0")
    @Max(value = 100, message = "Poids max = 100")
    private Double weight;

    public Double getWeight() {
        return weight;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

}
