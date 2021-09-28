package com.techelevator.model;

public class ReviewUser {
    private String reviewId;
    private String reviewText;
    private String rating;
    private String imageUrl;
    private String name;

    public ReviewUser(String reviewId, String reviewText, String rating, String imageUrl, String name) {
        this.reviewId = reviewId;
        this.reviewText = reviewText;
        this.rating = rating;
        this.imageUrl = imageUrl;
        this.name = name;
    }

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
