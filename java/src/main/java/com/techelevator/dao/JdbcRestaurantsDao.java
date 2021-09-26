package com.techelevator.dao;

import com.techelevator.model.Restaurant;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcRestaurantsDao implements RestaurantsDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcRestaurantsDao (JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Restaurant getRestaurantByRestaurantId(int restaurantId) {
        Restaurant restaurant = new Restaurant();
        String sql ="SELECT restaurant_id, restaurant_name, yelp_id FROM restaurants WHERE restaurant_id = ?";
        SqlRowSet results =jdbcTemplate.queryForRowSet(sql,restaurantId);
        if (results.next()) {
            restaurant = mapRowToRestaurants(results);
        }
        return restaurant;
    }

    @Override
    public void saveLikedRestaurant (String restaurantName, String yelpId) {
        String query = "INSERT INTO restaurants (restaurant_name, yelp_id) " +
                       "VALUES (?, ?);";
        jdbcTemplate.update(query, restaurantName, yelpId);
    }

    private Restaurant mapRowToRestaurants(SqlRowSet results){
        Restaurant restaurant = new Restaurant();
        restaurant.setYelpId(results.getString("yelp_id"));
        restaurant.setRestaurantId(results.getInt("restaurant_id"));
        restaurant.setRestaurantName(results.getString("restaurant_name"));
        return restaurant;
    }

}
