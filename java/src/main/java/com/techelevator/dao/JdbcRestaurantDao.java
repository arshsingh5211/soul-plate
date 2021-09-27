package com.techelevator.dao;

import com.techelevator.model.Restaurant;
import com.techelevator.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcRestaurantDao implements RestaurantDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcRestaurantDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Restaurant getRestaurant(int restaurantId) {
        Restaurant restaurant = new Restaurant();
        String sql ="SELECT restaurant_id, restaurant_name, yelp_id FROM restaurants WHERE restaurant_id = ?";
        SqlRowSet results =jdbcTemplate.queryForRowSet(sql,restaurantId);
        if (results.next()) {
            restaurant = mapRowToRestaurants(results);
        }
        return restaurant;
    }

    @Override
    public Restaurant saveLikedRestaurant (Restaurant restaurant) {
        String query = "INSERT INTO restaurants (restaurant_name, yelp_id) VALUES (?, ?) RETURNING restaurant_id;";
        Integer newId = jdbcTemplate.queryForObject(query, Integer.class, restaurant.getRestaurantName(),
                restaurant.getYelpId());
        return getRestaurant(newId);
    }

    private Restaurant mapRowToRestaurants(SqlRowSet results){
        Restaurant restaurant = new Restaurant();
        restaurant.setYelpId(results.getString("yelp_id"));
        restaurant.setRestaurantId(results.getInt("restaurant_id"));
        restaurant.setRestaurantName(results.getString("restaurant_name"));
        return restaurant;
    }

}
