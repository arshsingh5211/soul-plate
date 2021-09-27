package com.techelevator.dao;

import com.techelevator.model.Restaurant;
import com.techelevator.model.User;

public interface RestaurantDao {
    public Restaurant getRestaurant(int restaurantId);
    public Restaurant saveLikedRestaurant (Restaurant restaurant);
}
