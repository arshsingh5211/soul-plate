package com.techelevator.model;

public class Restaurants {
    private int restaurantId;
    private String restaurantName;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String rating;
    private String imgUrl;
    private String yelpId;
    private String categoryName;

    public Restaurants(String restaurantName, String address, String city, String state, String zipCode,
                       String rating, String imgUrl, String yelpId, String categoryName) {
        this.restaurantName = restaurantName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.rating = rating;
        this.imgUrl = imgUrl;
        this.yelpId = yelpId;
        this.categoryName = categoryName;
    }

    public Restaurants(int restaurantId, String restaurantName, String yelpId) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.yelpId = yelpId;
    }

    public Restaurants(){

    }

    public int getRestaurantId() {
        return restaurantId;
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

    public void setYelpId(String yelpId) {
        this.yelpId = yelpId;
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}




}
