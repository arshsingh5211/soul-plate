package com.techelevator.controller;

import com.techelevator.dao.RestaurantDao;
import com.techelevator.dao.UserDao;
import com.techelevator.dao.UserPreferencesDao;
import com.techelevator.model.*;
import com.techelevator.services.YelpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
@CrossOrigin
@RestController
public class RestaurantController {

    @Autowired
    YelpService yelpService;
    @Autowired
    UserPreferencesDao userPreferencesDao;
    @Autowired
    RestaurantDao restaurantDAO;
    @Autowired
    UserDao userDao;

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(path="/restaurants", method = RequestMethod.GET)
    public List<Restaurants> listSearchResults(@RequestParam String foodPref, @RequestParam String location) {
        return yelpService.getSearchResults(foodPref, location);
    }

    // todo : restaurant_id is always 0, category_name is no longer needed

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(path="/restaurants/{id}", method = RequestMethod.GET)
    public RestaurantDetails getRestaurantDetails(@PathVariable String id) {
        return yelpService.getRestaurantDetails(id);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(path = "/restaurant", method = RequestMethod.GET)
    public Restaurants getRandomRestaurant(@RequestParam String foodPref, @RequestParam String location) {
        return yelpService.getRandomRestaurant(yelpService.getSearchResults(foodPref, location));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(path = "/liked", method = RequestMethod.POST)
    public void addLikedRestaurant(@RequestBody Restaurants restaurants, Principal principal) {
        String user = principal.getName();
        int id = userDao.findIdByUsername(user);
        restaurantDAO.saveLikedRestaurant(restaurants, id);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(path = "/liked", method = RequestMethod.GET)
    public List<Restaurants> getLikedRestaurants(Principal principal) {
        String user = principal.getName();
        int id = userDao.findIdByUsername(user);
        return restaurantDAO.getLikedRestaurants(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(path = "/liked/{id}", method = RequestMethod.DELETE)
    public void deleteFromLiked(@PathVariable int id) {
        restaurantDAO.deleteLikedRestaurant(id);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(path = "/restaurants/{id}/reviews", method = RequestMethod.GET)
    public List<ReviewUser> getReview(@PathVariable String id) {
        return yelpService.getReview(id);
    }

}
