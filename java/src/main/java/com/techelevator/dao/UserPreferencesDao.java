package com.techelevator.dao;

import com.techelevator.model.UserPreferences;

import java.util.List;

public interface UserPreferencesDao {

     public UserPreferences getPreferencesId(int preference_id);

     public List<UserPreferences> getPreferencesByUserId(int userId);

     public void setProfilePreferences(int userId, String name, int homeZip, String preference);
     public List<UserPreferences> getAllPreferences();
}
