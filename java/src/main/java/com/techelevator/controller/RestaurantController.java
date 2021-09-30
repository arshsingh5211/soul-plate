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

import javax.validation.Valid;
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
    public List<Restaurant> listSearchResults(@RequestParam String foodPref, @RequestParam String location) {
        return yelpService.getSearchResults(foodPref, location);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(path="/restaurants/{id}", method = RequestMethod.GET)
    public RestaurantDetails getRestaurantDetails(@PathVariable String id) {
        return yelpService.getRestaurantDetails(id);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(path = "/restaurant", method = RequestMethod.GET)
    public Restaurant getRandomRestaurant(@RequestParam String foodPref, @RequestParam String location) {
        return yelpService.getRandomRestaurant(yelpService.getSearchResults(foodPref, location));
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(path = "/liked", method = RequestMethod.POST)
    public void addLikedRestaurant(@Valid @RequestBody Restaurant restaurant, Principal principal) {
        System.out.println(principal.toString());
        String user = principal.getName();
        int id = userDao.findIdByUsername(user);
        restaurantDAO.saveLikedRestaurant(restaurant, id);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(path = "/{id}/liked", method = RequestMethod.GET)
    public List<Restaurant> getLikedRestaurants(@PathVariable int id) {
        return restaurantDAO.getLikedRestaurants(id);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(path = "/restaurants/{id}/reviews", method = RequestMethod.GET)
    public List<ReviewUser> getReview(@PathVariable String id) {
        return yelpService.getReview(id);
    }

}
