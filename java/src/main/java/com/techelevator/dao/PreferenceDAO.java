package com.techelevator.dao;

import com.techelevator.model.Preference;

import java.util.List;

public interface PreferenceDAO {

     public Preference getUserPreferences(int preferenceId);

     public List<Preference> getPreferencesByUserId(int userId);

     public Preference createProfilePreferences(Preference newPreference, int userId);
     public List<Preference> getAllPreferences();
}
