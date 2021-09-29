package com.techelevator.dao;

import com.techelevator.model.Restaurant;
import com.techelevator.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,restaurantId);
        if (results.next()) {
            restaurant = mapRowToRestaurants(results);
        }
        return restaurant;
    }

    @Override
    public List<Restaurant> getLikedRestaurants(int userId) {
        List<Restaurant> restaurantList = new ArrayList<>();
        String query = "SELECT * FROM restaurants JOIN user_restaurants USING (restaurant_id) " +
                        "JOIN users USING (user_id) WHERE user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(query, userId);
        while (results.next()) {
            restaurantList.add(mapRowToRestaurants(results));
        }
        return restaurantList;
    }

    @Override
    public Restaurant saveLikedRestaurant (Restaurant restaurant, int userId) {
        String query = "BEGIN; " +
                            "INSERT INTO restaurants (restaurant_name, yelp_id) VALUES (?, ?) RETURNING restaurant_id; " +
                            "INSERT INTO user_restaurants (user_id, restaurant_id) " +
                            "VALUES ((SELECT user_id FROM users WHERE user_id = ?), " +
                            "(SELECT restaurant_id FROM restaurants WHERE restaurant_id = ?)); " +
                       "COMMIT;";
        Integer newId = jdbcTemplate.queryForObject(query, Integer.class,
                        restaurant.getRestaurantName(), restaurant.getYelpId(), userId, 3);
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
