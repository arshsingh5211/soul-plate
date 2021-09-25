package com.techelevator.dao;

import com.techelevator.model.Restaurants;
import com.techelevator.services.YelpService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcRestaurantsDao implements RestaurantsDao {
    private JdbcTemplate jdbcTemplate;

public JdbcRestaurantsDao (JdbcTemplate jdbcTemplate){
    this.jdbcTemplate = jdbcTemplate;

}





//    @Override
//    public String getDescriptionByRestaurantId(int restaurant_id) {
//        Restaurants restaurant = new Restaurants();
//        String sql ="SELECT description FROM restaurants WHERE restaurant_id=?";
//        SqlRowSet results =jdbcTemplate.queryForRowSet(sql,restaurant_id);
//        if(results.next()){
//            restaurant = mapRowToRestaurants(results);
//
//        }
//
//        return restaurant.getDescription();
//    }

    @Override
    public String getPhoneNumberByRestaurantId(int restaurant_id) {
        Restaurants restaurant = new Restaurants();
        String sql ="SELECT phone_number FROM restaurants WHERE restaurant_id=?";
        SqlRowSet results =jdbcTemplate.queryForRowSet(sql,restaurant_id);
        if(results.next()) {
            restaurant = mapRowToRestaurants(results);


        }
            return restaurant.getPhoneNumber();
    }

    @Override
    public String getAddressByRestaurantId(int restaurant_id) {

        Restaurants restaurant = new Restaurants();
        String sql ="SELECT address FROM restaurants WHERE restaurant_id=?";
        SqlRowSet results =jdbcTemplate.queryForRowSet(sql,restaurant_id);
        if(results.next()) {
            restaurant = mapRowToRestaurants(results);


        }

            return restaurant.getAddress();
    }

    @Override
    public String getStateByRestaurantId(int restaurant_id) {

        Restaurants restaurant = new Restaurants();
        String sql ="SELECT state FROM restaurants WHERE restaurant_id=?";
        SqlRowSet results =jdbcTemplate.queryForRowSet(sql,restaurant_id);
        if(results.next()) {
            restaurant = mapRowToRestaurants(results);
        }
            return restaurant.getState();
    }

    @Override
    public String getCityByRestaurantId(int restaurant_id) {
        Restaurants restaurant = new Restaurants();
        String sql ="SELECT city FROM restaurants WHERE restaurant_id=?";
        SqlRowSet results =jdbcTemplate.queryForRowSet(sql,restaurant_id);
        if(results.next()) {
            restaurant = mapRowToRestaurants(results);
        }
        return restaurant.getCity();
    }

    @Override
    public String getRestaurantNameByRestaurantId(String restaurant_id) {
        Restaurants restaurant = new Restaurants();
        String sql ="SELECT restaurant_name FROM restaurants WHERE restaurant_id=?";
        SqlRowSet results =jdbcTemplate.queryForRowSet(sql,restaurant_id);
        if(results.next()) {
            restaurant = mapRowToRestaurants(results);
        }
        return restaurant.getRestaurantName();
    }

    @Override
    public String getZipcodeByRestaurantId(String restaurant_id) {
        Restaurants restaurant = new Restaurants();
        String sql ="SELECT zip_code FROM restaurants WHERE restaurant_id=?";
        SqlRowSet results =jdbcTemplate.queryForRowSet(sql,restaurant_id);
        if(results.next()) {
            restaurant = mapRowToRestaurants(results);
        }
        return restaurant.getZipCode();
    }

    @Override
    public String getRatingByRestaurantId(int restaurant_id) {
        Restaurants restaurant = new Restaurants();
        String sql ="SELECT rating FROM restaurants WHERE restaurant_id=?";
        SqlRowSet results =jdbcTemplate.queryForRowSet(sql,restaurant_id);
        if(results.next()) {
            restaurant = mapRowToRestaurants(results);
        }
        return restaurant.getRating();
    }

    private Restaurants mapRowToRestaurants(SqlRowSet results){
            Restaurants  restaurant = new Restaurants();
            restaurant.setAddress(results.getString("address"));
            restaurant.setRestaurantName(results.getString("restaurant_name"));
            //restaurant.setDescription(results.getString("description"));
            restaurant.setRestaurantId(results.getInt("restaurant_id"));
            restaurant.setPhoneNumber(results.getString("phone_number"));
            restaurant.setCity(results.getString("city"));
            restaurant.setState(results.getString("state"));
            restaurant.setZipCode(results.getString("zip_code"));
            restaurant.setRating(results.getString("rating"));

            return restaurant;
    }

}
