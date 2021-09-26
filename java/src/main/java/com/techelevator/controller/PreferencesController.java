package com.techelevator.controller;

import com.techelevator.dao.UserPreferencesDao;
import com.techelevator.model.UserPreferences;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class PreferencesController {

    @Autowired
    UserPreferencesDao userPreferencesDao;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/preferences", method = RequestMethod.POST)
    public void createUserPreferences(@RequestBody UserPreferences newPreferences) {
        userPreferencesDao.createProfilePreferences(newPreferences);
    }

    @RequestMapping(path = "/preferences", method = RequestMethod.PUT)
    public void updateUserPreferences(@RequestBody UserPreferences newPreferences) {
        userPreferencesDao.updateProfilePreferences(newPreferences);
    }
}
