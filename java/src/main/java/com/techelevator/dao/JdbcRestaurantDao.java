package com.techelevator.dao;

import com.techelevator.model.Restaurants;
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
    public Restaurants getRestaurant(int yelpId) {
        Restaurants restaurants = new Restaurants();
        String sql ="SELECT restaurant_id, restaurant_name FROM restaurants WHERE yelp_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, yelpId);
        if (results.next()) {
            restaurants = mapRowToRestaurants(results);
        }
        return restaurants;
    }

    @Override
    public List<Restaurants> getLikedRestaurants(int userId) {
        List<Restaurants> restaurantsList = new ArrayList<>();
        String query = "SELECT * FROM restaurants JOIN user_restaurants USING (yelp_id) " +
                        "JOIN users USING (user_id) WHERE user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(query, userId);
        while (results.next()) {
            restaurantsList.add(mapRowToRestaurants(results));
        }
        return restaurantsList;
    }

    @Override
    public void saveLikedRestaurant(Restaurants restaurants, int userId) {
        String query = "INSERT INTO restaurants (restaurant_name, yelp_id) " +
                        "VALUES (?, ?) ON CONFLICT (yelp_id) DO UPDATE " +
                            "SET restaurant_name = excluded.restaurant_name " +
                        "RETURNING restaurant_id;";
        Integer restId = jdbcTemplate.queryForObject(query, Integer.class, restaurants.getRestaurantName(),
                restaurants.getYelpId());
        String query2 = "INSERT INTO user_restaurants (user_id, yelp_id) " +
                        "VALUES ((SELECT user_id FROM users WHERE user_id = ?), ?) " +
                        "ON CONFLICT (user_restaurants_id) DO NOTHING";
        jdbcTemplate.update(query2, userId, restId);
        String query3 = "INSERT INTO categories(category_name) " +
			        	"VALUES (?) ON CONFLICT (category_name) DO NOTHING " +
			            "RETURNING category_id;";
        Integer categoryId = jdbcTemplate.queryForObject(query3, Integer.class, restaurants.getCategoryName());
        String query4 = "INSERT INTO restaurant_categories (category_id, restaurant_id) " +
                        "VALUES (?, ?)";
        jdbcTemplate.update(query4, categoryId, restId);
    }
    
//    @Override
//    public void saveLikedRestaurant(Restaurants restaurant, int userId) {
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

    private Restaurants mapRowToRestaurants(SqlRowSet results) {
        Restaurants restaurants = new Restaurants();
        restaurants.setYelpId(results.getString("yelp_id"));
        restaurants.setRestaurantId(results.getInt("restaurant_id"));
        restaurants.setRestaurantName(results.getString("restaurant_name"));
        restaurants.setState(results.getString("state"));
        return restaurants;
    }
}
