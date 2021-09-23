package com.techelevator.model;

import java.util.List;

public class Restaurants {

    public Restaurants(String restaurantName, String phoneNumber, String address, String rating, List<String> transactions) {
        this.restaurantName = restaurantName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.rating = rating;
        this.transactions = transactions;
    }

    public Restaurants(String restaurantName, String phoneNumber, String address, String city, String state, String zipCode,
                       String rating, List<String> transactions, String price, String imgUrl, String category,
                       String weeklyHours, String yelpId) {
        this.restaurantName = restaurantName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.rating = rating;
        this.transactions = transactions;
        this.price = price;
        this.imgUrl = imgUrl;
        this.category = category;
        this.weeklyHours = weeklyHours;
        this.yelpId = yelpId;
    }

    private String restaurantName;
    private String phoneNumber;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String  rating;
    private List<String> transactions;
    private String price;
    private String imgUrl;
    private String category;
    private String weeklyHours;
    private String yelpId;

    public void setTransactions(List<String> transactions) {
        this.transactions = transactions;
    }

    public List<String> getTransactions() {
        return transactions;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getYelpId() {
        return yelpId;
    }

    public void setRestaurantId(int restaurantId) {
        this.yelpId = yelpId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getWeeklyHours() {
        return weeklyHours;
    }

    public void setWeeklyHours(String weeklyHours) {
        this.weeklyHours = weeklyHours;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Restaurants(){

    }


}
