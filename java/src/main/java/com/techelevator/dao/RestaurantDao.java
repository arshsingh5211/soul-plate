package com.techelevator.dao;

import com.techelevator.model.Restaurant;
import com.techelevator.model.User;

import java.util.List;

public interface RestaurantDao {
    public Restaurant getRestaurant(int restaurantId);
    public List<Restaurant> getLikedRestaurants(int userId);
    public void saveLikedRestaurant (Restaurant restaurant, int userId);
    public void deleteLikedRestaurant(int userId);
}
