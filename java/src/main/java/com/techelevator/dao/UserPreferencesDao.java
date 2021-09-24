package com.techelevator.dao;

import com.techelevator.model.UserPreferences;

import java.util.List;

public interface UserPreferencesDao {

     public UserPreferences getPreferencesId(int preference_id);

     public List<UserPreferences> getPreferencesByUserId(int userId);

     public void setProfilePreference(String preference, int homeZip);
     public List<UserPreferences> getAllPreferences();
}
