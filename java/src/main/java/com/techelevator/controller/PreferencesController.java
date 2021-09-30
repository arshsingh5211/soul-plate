package com.techelevator.controller;

import com.techelevator.dao.CategoriesDao;
import com.techelevator.dao.JdbcUserDao;
import com.techelevator.dao.UserPreferencesDao;
import com.techelevator.model.Categories;
import com.techelevator.model.UserPreferences;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(path = "/preferences", method = RequestMethod.GET)
    public List<UserPreferences> getUserPreference (Principal principal) {
        String user = principal.getName();
        int id = userDao.findIdByUsername(user);
        return userPreferencesDao.getPreferencesByUserId(id);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/preferences", method = RequestMethod.POST)
    public void createUserPreferences(@RequestBody UserPreferences newPreferences, Principal principal) {
        String user = principal.getName();
        int id = userDao.findIdByUsername(user);
        userPreferencesDao.createProfilePreferences(newPreferences, id);
    }

/*    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(path = "/preferences", method = RequestMethod.PUT)
    public void updateUserPreferences(@RequestBody UserPreferences newPreferences, Principal principal) {
        String user = principal.getName();
        int id = userDao.findIdByUsername(user);
        userPreferencesDao.updateProfilePreferences(newPreferences, id);
    }*/

    @RequestMapping(path = "/categories/{id}", method = RequestMethod.GET)
    public Categories getCategory (@PathVariable int id) {
        return categoriesDao.getCategory(id);
    }
}
