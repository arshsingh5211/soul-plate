package com.techelevator.dao;

import com.techelevator.model.Preferences;

import java.util.List;

public interface PreferenceDAO {
     public List<Preferences> getPreferencesByUserId(int userId);
     public void createPreferences(Preferences newPreferences, int userId);
     public List<Preferences> getAllPreferences();
}
