package com.techelevator.model;

public class Restaurant {
    private String yelpId;
    private String restaurantName;
    private String address;
    private String city;
    private String state;
    private String zipCode;

    public Restaurant(String yelpId, String restaurantName, String address, String city, String state, String zipCode) {
        this.yelpId = yelpId;
        this.restaurantName = restaurantName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public Restaurant(String yelpId, String restaurantName) {
        this.yelpId = yelpId;
        this.restaurantName = restaurantName;
    }

    public Restaurant(){}

    public Restaurant(String yelpId, String name, String address, String city, String state, String zipCode, String rating,
                      String imgUrl) {
        this.yelpId = yelpId;
        this.restaurantName = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

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




}
