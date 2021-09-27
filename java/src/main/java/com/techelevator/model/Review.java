package com.techelevator.model;

import java.time.LocalDate;
import java.util.List;

public class Review {
    private List<String> reviews;

    public Review (List<String> reviews) {
        this.reviews = reviews;
    }

    public Review() {
    }

    public List<String> getReviews() {
        return reviews;
    }

    public void setReviews(List<String> reviews) {
        this.reviews = reviews;
    }
}
