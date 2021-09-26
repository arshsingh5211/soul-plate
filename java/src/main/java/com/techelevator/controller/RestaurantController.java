package com.techelevator.controller;

import com.techelevator.dao.RestaurantsDao;
import com.techelevator.dao.UserPreferencesDao;
import com.techelevator.model.RestaurantDetails;
import com.techelevator.model.UserPreferences;
import com.techelevator.model.Restaurant;
import com.techelevator.services.YelpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
public class RestaurantController {

    @Autowired
    YelpService yelpService;
    @Autowired
    UserPreferencesDao userPreferencesDao;
    @Autowired
    RestaurantsDao restaurantsDao;


    @RequestMapping(path="/restaurants", method = RequestMethod.GET)
    public List<Restaurant> listSearchResults(@RequestParam String foodPref, @RequestParam String location) {
        return yelpService.getSearchResults(foodPref, location);
    }

    @RequestMapping(path="/restaurants/{id}", method = RequestMethod.GET)
    public RestaurantDetails getRestaurantDetails(@PathVariable String id) {
        return yelpService.getRestaurantDetails(id);
    }

    @RequestMapping(path = "/preferences", method = RequestMethod.POST)
    public void editUserPreferences(@RequestBody UserPreferences userPreference) {
        userPreferencesDao.setProfilePreferences(userPreference.getUserId(), userPreference.getName(), userPreference.getHomeZip(), userPreference.getPreference());
    }

    @RequestMapping(path = "/restaurant", method = RequestMethod.GET)
    public Restaurant getRandomRestaurant(@RequestParam String foodPref, @RequestParam String location) {
        return yelpService.getRandomRestaurant(yelpService.getSearchResults(foodPref, location));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/liked", method = RequestMethod.POST)
    public void addLikedRestaurant(@RequestBody Restaurant restaurant) {
        restaurantsDao.saveLikedRestaurant(restaurant.getRestaurantName(), restaurant.getYelpId());
    }


}
