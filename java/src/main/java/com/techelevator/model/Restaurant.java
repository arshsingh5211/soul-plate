package com.techelevator.model;

import java.util.List;

public class Restaurant {
    private String yelpId;
    private String restaurantName;
    private double rating;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String phoneNumber;


    public Restaurant(String yelpId, String restaurantName, double rating, String address, String city, String state,
                      String zipCode, String phoneNumber) {
        this.yelpId = yelpId;
        this.restaurantName = restaurantName;
        this.rating = rating;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
    }

    public Restaurant(String yelpId, String restaurantName) {
        this.yelpId = yelpId;
        this.restaurantName = restaurantName;
    }

    public Restaurant(){}

    public String getYelpId() {
        return yelpId;
    }

    public void setYelpId(String yelpId) {
        this.yelpId = yelpId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

}
