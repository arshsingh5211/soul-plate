package com.techelevator.dao;

import com.techelevator.model.UserPreferences;

import java.util.List;

public interface UserPreferencesDao {

     public UserPreferences getUserPreferences(int preferenceId);

     public List<UserPreferences> getPreferencesByUserId(int userId);

     public UserPreferences createProfilePreferences(UserPreferences newPreferences);
     public void updateProfilePreferences(UserPreferences userPreferences);
     public List<UserPreferences> getAllPreferences();
}
