package com.example.review.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "reviews")
public class Review {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "productId est obligatoire")
    private Long productId;

    @NotBlank(message = "L'auteur est obligatoire")
    private String author;

    @NotBlank(message = "Le sujet est obligatoire")
    private String subject;

    private String content;

    @Min(value = 0, message = "Note minimale = 0")
    @Max(value = 5, message = "Note maximale = 5")
    private Integer rating;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public Long getProductId() {
        return productId;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public Integer getRating() {
        return rating;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
