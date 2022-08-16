package com.techelevator.dao;

import com.techelevator.model.Restaurant;

import java.util.List;

public interface RestaurantDAO {
    public Restaurant getRestaurant(int restaurantId);
    public List<Restaurant> getLikedRestaurants(int userId);
    public void saveLikedRestaurant (Restaurant restaurant, int userId);
    public void deleteLikedRestaurant(int userId);
}
