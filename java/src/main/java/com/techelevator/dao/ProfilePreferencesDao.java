package com.techelevator.dao;

import com.techelevator.model.ProfilePreferences;

import java.util.List;

public interface ProfilePreferencesDao {

     public ProfilePreferences getPreferencesId(int preference_id);

     public List<ProfilePreferences> getPreferencesByUserId(int userId);

     public void setProfilePreference(String preference, int homeZip);

}
