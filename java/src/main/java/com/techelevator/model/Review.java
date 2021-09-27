package com.techelevator.model;

import java.time.LocalDate;

public class Review {
    private String yelpId;
    private String url;
    private String text;
    private String rating;
    private String timeCreated;
    private String reviewUser;

    public Review(String yelpId, String url, String text, String rating, String timeCreated, String reviewUser) {
        this.yelpId = yelpId;
        this.url = url;
        this.text = text;
        this.rating = rating;
        this.timeCreated = timeCreated;
        this.reviewUser = reviewUser;
    }

    public Review() {
    }

    public String getYelpId() {
        return yelpId;
    }

    public void setYelpId(String yelpId) {
        this.yelpId = yelpId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(String timeCreated) {
        this.timeCreated = timeCreated;
    }

    public String getReviewUser() {
        return reviewUser;
    }

    public void setReviewUser(String reviewUser) {
        this.reviewUser = reviewUser;
    }
}
