package com.techelevator.dao;

import com.techelevator.model.Restaurants;

import java.util.List;

public interface RestaurantDao {
    public Restaurants getRestaurant(int restaurantId);
    public List<Restaurants> getLikedRestaurants(int userId);
    public void saveLikedRestaurant (Restaurants restaurants, int userId);
    public void deleteLikedRestaurant(int userId);
}
