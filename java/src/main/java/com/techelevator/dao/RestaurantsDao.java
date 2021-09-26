package com.techelevator.dao;

import com.techelevator.model.Restaurant;

public interface RestaurantsDao {

    public Restaurant getRestaurantByRestaurantId(int restaurantId);
    public void saveLikedRestaurant (String restaurantName, String yelpId);


    
}
