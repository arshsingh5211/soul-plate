package com.techelevator.controller;

import com.techelevator.dao.CategoriesDao;
import com.techelevator.dao.JdbcUserDao;
import com.techelevator.dao.UserPreferencesDao;
import com.techelevator.model.Categories;
import com.techelevator.model.UserPreferences;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

<<<<<<< HEAD
import java.security.Principal;
=======
import java.util.List;
>>>>>>> e70e04659d2f04933828c6eae71975df8f1e96d9

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
<<<<<<< HEAD
    @RequestMapping(path = "/preferences", method = RequestMethod.POST)
    public void createUserPreferences(@RequestBody UserPreferences newPreferences) {

        userPreferencesDao.createProfilePreferences(newPreferences);
=======
    @RequestMapping(path = "/{id}/preferences", method = RequestMethod.POST)
    public void createUserPreferences(@RequestBody UserPreferences newPreferences, @PathVariable int id) {
        userPreferencesDao.createProfilePreferences(newPreferences, id);
>>>>>>> e70e04659d2f04933828c6eae71975df8f1e96d9
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
