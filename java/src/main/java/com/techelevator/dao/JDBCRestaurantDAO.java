package com.techelevator.dao;

import com.techelevator.model.Restaurant;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JDBCRestaurantDAO implements RestaurantDAO {
    private JdbcTemplate jdbcTemplate;

    public JDBCRestaurantDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Restaurant getRestaurant(int yelpId) {
        Restaurant restaurant = new Restaurant();
        String sql ="SELECT restaurant_id, restaurant_name FROM restaurant WHERE yelp_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, yelpId);
        if (results.next()) {
            restaurant = mapRowToRestaurants(results);
        }
        return restaurant;
    }

    @Override
    public List<Restaurant> getLikedRestaurants(int userId) {
        List<Restaurant> restaurantList = new ArrayList<>();
        String query = "SELECT yelp_id, restaurant_name, rating, address, city, state, zip_code FROM restaurants JOIN user_restaurants USING (yelp_id) " +
                        "JOIN users USING (user_id) WHERE user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(query, userId);
        while (results.next()) {
            restaurantList.add(mapRowToRestaurants(results));
        }
        return restaurantList;
    }

    @Override
    public void saveLikedRestaurant(Restaurant restaurant, int userId) {
        String query = "INSERT INTO restaurants (yelp_id, restaurant_name, rating, address, city, state, zip_code) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(query, restaurant.getYelpId(), restaurant.getRestaurantName(), restaurant.getRating(),
                restaurant.getAddress(), restaurant.getCity(), restaurant.getState(), restaurant.getZipCode());
        String query2 = "INSERT INTO user_restaurants (user_id, yelp_id) " +
                        "VALUES ((SELECT user_id FROM users WHERE user_id = ?), ?) " +
                        "ON CONFLICT (user_restaurants_id) DO NOTHING";
        jdbcTemplate.update(query2, userId, restaurant.getYelpId());
        String query3 = "INSERT INTO categories(category_name) " +
			        	"VALUES (?) ON CONFLICT (category_name) DO NOTHING " +
			            "RETURNING category_id;";
    }
    
//    @Override
//    public void saveLikedRestaurant(Restaurant restaurant, int userId) {
//    	String query = "INSERT INTO restaurants (restaurant_name, yelp_id) " +
//    					"VALUES (?, ?) ON CONFLICT (yelp_id) DO UPDATE " +
//    						"SET restaurant_name = excluded.restaurant_name " +
//    					"RETURNING restaurant_id;";
//    }

    @Override
    public void deleteLikedRestaurant(int userId) {
        String query = "DELETE FROM user_restaurants WHERE user_restaurants_id = ?";
        jdbcTemplate.update(query, userId);
    }

    private Restaurant mapRowToRestaurants(SqlRowSet results) {
        Restaurant restaurant = new Restaurant();
        restaurant.setYelpId(results.getString("yelp_id"));
        restaurant.setRestaurantName(results.getString("restaurant_name"));
        restaurant.setAddress(results.getString("address"));
        restaurant.setRating(results.getDouble("rating"));
        restaurant.setCity(results.getString("city"));
        restaurant.setState(results.getString("state"));
        restaurant.setZipCode(results.getString("zip_code"));
        return restaurant;
    }
}
