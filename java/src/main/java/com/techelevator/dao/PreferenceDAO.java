package com.techelevator.dao;

import com.techelevator.model.Preferences;

import java.util.List;

public interface PreferenceDAO {
     Preferences getPreference(int preferencesId);
     List<Preferences> getPreferencesByUserId(int userId);
     void createPreferences(Preferences newPreferences, int userId);
     List<Preferences> getAllPreferences();
     boolean doesPreferenceExistForUser(int userId, Preferences preferencesId);
}
