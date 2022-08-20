package com.techelevator.dao;

import com.techelevator.model.Preferences;

import java.util.List;

public interface PreferenceDAO {
     public Preferences getPreference(int preferencesId, int userPreferencesId);
     public List<Preferences> getPreferencesByUserId(int userId);
     public Preferences createPreferences(Preferences newPreferences, int userId);
     public List<Preferences> getAllPreferences();
}
