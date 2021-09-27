package com.techelevator.model;

import java.util.List;

public class RestaurantDetails {
    private String restaurantName;
    private String phoneNumber;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String  rating;
    private List<String> photos;
    private List<String> transactions;
    private String price;
    private String imgUrl;
    private String category;
    private boolean isOpenNow;
    private String yelpId;

    public RestaurantDetails(String restaurantName, String phoneNumber, String address, String city, String state,
                             String zipCode, String rating, List<String> photos, List<String> transactions, String price, String imgUrl,
                             String category, boolean isOpenNow, String yelpId) {
        this.restaurantName = restaurantName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.rating = rating;
        this.photos = photos;
        this.transactions = transactions;
        this.price = price;
        this.imgUrl = imgUrl;
        this.category = category;
        this.isOpenNow = isOpenNow;
        this.yelpId = yelpId;
    }

    public RestaurantDetails() {}

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

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
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

    public boolean isOpenNow() {
        return isOpenNow;
    }

    public void setOpenNow(boolean openNow) {
        isOpenNow = openNow;
    }

    public String getYelpId() {
        return yelpId;
    }

    public void setYelpId(String yelpId) {
        this.yelpId = yelpId;
    }
}
