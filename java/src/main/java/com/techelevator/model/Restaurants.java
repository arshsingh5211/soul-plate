package com.techelevator.model;

public class Restaurants {

    public Restaurants(String restaurant_name, String phone_number, String address, String rating) {
        this.restaurant_name = restaurant_name;
        this.phone_number = phone_number;
        this.address = address;
        this.rating = rating;
    }

    public Restaurants(String restaurant_name, String phone_number, String address, String rating, String imgUrl, String category, String price, String weeklyHours, String transactions) {
        this.restaurant_name = restaurant_name;
        this.phone_number = phone_number;
        this.address = address;
        this.rating = rating;
        this.imgUrl = imgUrl;
        this.category = category;
        this.price = price;
        this.weeklyHours = weeklyHours;
        this.transactions = transactions;
    }

    private String restaurant_name;
    private String description;
    private String phone_number;
    private String address;
    private String city;
    private String state;
    private int zip_code;
    private String  rating;

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    private String price;
    private String imgUrl;
    private String category;
    private String weeklyHours;
    private String transactions;

    public String getTransactions() {
        return transactions;
    }

    public void setTransactions(String transactions) {
        this.transactions = transactions;
    }

    private int  restaurant_id;

    public int getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public String getRestaurant_name() {
        return restaurant_name;
    }

    public void setRestaurant_name(String restaurant_name) {
        this.restaurant_name = restaurant_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
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

    public int getZip_code() {
        return zip_code;
    }

    public void setZip_code(int zip_code) {
        this.zip_code = zip_code;
    }

    public Restaurants(){

    }


}
