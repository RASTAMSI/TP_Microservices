package com.example.recommendation.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "recommendations")
public class Recommendation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "productId est obligatoire")
    private Long productId;

    @NotBlank(message = "L'auteur est obligatoire")
    private String author;

    private String content;

    @Min(value = 0, message = "Rate min = 0")
    @Max(value = 100, message = "Rate max = 100")
    private Integer rate;

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public Long getProductId() {
        return productId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }
}
