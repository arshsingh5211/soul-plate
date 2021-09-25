package com.techelevator.controller;

import com.techelevator.dao.JdbcUserPreferencesDao;
import com.techelevator.model.UserPreferences;
import com.techelevator.model.Restaurants;
import com.techelevator.services.YelpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
public class RestaurantController {

    @Autowired
    YelpService yelpService;

    @Autowired
    JdbcUserPreferencesDao profilePreferences;

    @RequestMapping(path="/restaurants", method = RequestMethod.GET)
    public List<Restaurants> listSearchResults(@RequestParam String foodPref, @RequestParam String location) {

        System.out.println("passed in: " + foodPref);
        System.out.println("passed in: " + location) ;

        return yelpService.getSearchResults(foodPref, location);
    }

    @RequestMapping(path="/restaurants/{id}", method = RequestMethod.GET)
    public Restaurants getRestaurantDetails(@PathVariable String id) {
        return yelpService.getRestaurantDetails(id);
    }

    @RequestMapping(path = "/preferences", method = RequestMethod.POST)
    public void editUserPreferences(@RequestBody UserPreferences userPreference) {
        profilePreferences.setProfilePreferences(userPreference.getUserId(), userPreference.getName(), userPreference.getHomeZip(), userPreference.getPreference());
    }



}
