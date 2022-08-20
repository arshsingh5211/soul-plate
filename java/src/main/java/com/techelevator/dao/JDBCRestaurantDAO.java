/*
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
        String query = "SELECT * FROM restaurants JOIN user_restaurants USING (yelp_id) " +
                        "JOIN users USING (user_id) WHERE user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(query, userId);
        while (results.next()) {
            restaurantList.add(mapRowToRestaurants(results));
        }
        return restaurantList;
    }

    @Override
    public void saveLikedRestaurant(Restaurant restaurant, int userId) {
        String query = "INSERT INTO restaurant (restaurant_name, yelp_id) " +
                        "VALUES (?, ?) ON CONFLICT (yelp_id) DO UPDATE " +
                            "SET restaurant_name = excluded.restaurant_name " +
                        "RETURNING restaurant_id;";
        Integer restId = jdbcTemplate.queryForObject(query, Integer.class, restaurant.getRestaurantName(),
                restaurant.getYelpId());
        String query2 = "INSERT INTO user_restaurants (user_id, yelp_id) " +
                        "VALUES ((SELECT user_id FROM users WHERE user_id = ?), ?) " +
                        "ON CONFLICT (user_restaurants_id) DO NOTHING";
        jdbcTemplate.update(query2, userId, restId);
        String query3 = "INSERT INTO categories(category_name) " +
			        	"VALUES (?) ON CONFLICT (category_name) DO NOTHING " +
			            "RETURNING category_id;";
        Integer categoryId = jdbcTemplate.queryForObject(query3, Integer.class, restaurant.getCategoryName());
        String query4 = "INSERT INTO restaurant_categories (category_id, restaurant_id) " +
                        "VALUES (?, ?)";
        jdbcTemplate.update(query4, categoryId, restId);
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
        restaurant.setRestaurantId(results.getInt("restaurant_id"));
        restaurant.setRestaurantName(results.getString("restaurant_name"));
        restaurant.setState(results.getString("state"));
        return restaurant;
    }
}
*/
