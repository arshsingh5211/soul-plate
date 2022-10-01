package com.techelevator.model;

import java.util.List;

public class Restaurant {
    private String yelpId;
    private String restaurantName;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String phoneNumber;
    private String rating;
    private List<String> pictureURLs;
    private List<String> transactions;
    private String price;
    private String imgUrl;
    private String category;
    private boolean isOpenNow;


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

/*    public Restaurant(String yelpId, String restaurantName, String address, String city, String state,
                      String zipCode, String phoneNumber, String rating, List<String> pictureURLs, List<String> transactions,
                      String price, String imgUrl, String category, boolean isOpenNow) {
        this.yelpId = yelpId;
        this.restaurantName = restaurantName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.rating = rating;
        this.pictureURLs = pictureURLs;
        this.transactions = transactions;
        this.price = price;
        this.imgUrl = imgUrl;
        this.category = category;
        this.isOpenNow = isOpenNow;
    }*/

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

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public List<String> getPictureURLs() {
        return pictureURLs;
    }

    public void setPictureURLs(List<String> pictureURLs) {
        this.pictureURLs = pictureURLs;
    }

    public List<String> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<String> transactions) {
        this.transactions = transactions;
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

    public boolean getIsOpenNow() {
        return isOpenNow;
    }

    public void setIsOpenNow(boolean isOpenNow) {
        this.isOpenNow = isOpenNow;
    }
}
