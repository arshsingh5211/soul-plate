package com.techelevator.controller;

import com.techelevator.dao.JDBCUserDAO;
import com.techelevator.dao.PreferenceDAO;
import com.techelevator.model.Preferences;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

import java.util.List;

@CrossOrigin
@RestController
public class PreferenceController {

    @Autowired
    PreferenceDAO preferenceDAO;
    @Autowired
    JDBCUserDAO userDao;

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(path = "/preferences", method = RequestMethod.GET)
    public List<Preferences> getUserPreference (Principal principal) {
        String user = principal.getName();
        int id = userDao.findIdByUsername(user);
        return preferenceDAO.getPreferencesByUserId(id);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/preferences", method = RequestMethod.POST)
    public String createUserPreferences(@RequestBody Preferences newPreferences, Principal principal) {
        String user = principal.getName();
        int id = userDao.findIdByUsername(user);
        System.out.println(user + ": " + id);
        System.out.println(newPreferences);
        preferenceDAO.createPreferences(newPreferences, id);
        return "does this preference already exist: " +
                newPreferences.getPreference() + " in " + newPreferences.getHomeZip() +
                ": " + preferenceDAO.doesPreferenceExistForUser(id, newPreferences);
    }

/*    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(path = "/preferences", method = RequestMethod.PUT)
    public void updateUserPreferences(@RequestBody Preferences newPreferences, Principal principal) {
        String user = principal.getName();
        int id = userDao.findIdByUsername(user);
        preferenceDAO.updateProfilePreferences(newPreferences, id);
    }*/
}
