package com.example.review.exceptions;

public class ReviewNotFoundException extends RuntimeException {
    public ReviewNotFoundException(String msg) { super(msg); }
}
