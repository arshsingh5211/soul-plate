package com.techelevator.model;

public class RestaurantCategories {

    private int categoryId;
    private int restaurantId;
    public RestaurantCategories(){

    }

    public int getCategoryId() {
        return categoryId;

    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }


}
