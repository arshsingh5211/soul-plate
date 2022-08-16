package com.techelevator.dao;

import com.techelevator.model.Preferences;

import java.util.List;

public interface PreferenceDAO {

     public Preferences getUserPreferences(int preferenceId);

     public List<Preferences> getPreferencesByUserId(int userId);

     public Preferences createProfilePreferences(Preferences newPreferences, int userId);
     public List<Preferences> getAllPreferences();
}
