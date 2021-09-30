package com.techelevator.controller;

import com.techelevator.dao.CategoriesDao;
import com.techelevator.dao.JdbcUserDao;
import com.techelevator.dao.UserPreferencesDao;
import com.techelevator.model.Categories;
import com.techelevator.model.UserPreferences;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

import java.util.List;

@CrossOrigin
@RestController
public class PreferencesController {

    @Autowired
    UserPreferencesDao userPreferencesDao;
    @Autowired
    CategoriesDao categoriesDao;
    @Autowired
    JdbcUserDao userDao;


    @RequestMapping(path = "{id}/preferences", method = RequestMethod.GET)
    public List<UserPreferences> getUserPreference (@PathVariable int id) {
        return userPreferencesDao.getPreferencesByUserId(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    /*@RequestMapping(path = "/preferences", method = RequestMethod.POST)
    public void createUserPreferences(@RequestBody UserPreferences newPreferences) {
        userPreferencesDao.createProfilePreferences(newPreferences);
    }*/
    @RequestMapping(path = "/{id}/preferences", method = RequestMethod.POST)
    public void createUserPreferences(@RequestBody UserPreferences newPreferences, @PathVariable int id) {
        userPreferencesDao.createProfilePreferences(newPreferences, id);
    }

    @RequestMapping(path = "/{id}/preferences", method = RequestMethod.PUT)
    public void updateUserPreferences(@RequestBody UserPreferences newPreferences, @PathVariable int id) {
        userPreferencesDao.updateProfilePreferences(newPreferences, id);
    }

    // didn't want to make a separate categories controller yet so for now just put it here

    @RequestMapping(path = "/categories/{id}", method = RequestMethod.GET)
    public Categories getCategory (@PathVariable int id) {
        return categoriesDao.getCategory(id);
    }
}
