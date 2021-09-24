package com.techelevator.dao;

import com.techelevator.model.UserPreferences;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcUserPreferencesDao implements UserPreferencesDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    JdbcUserPreferencesDao profilePreferencesDao;

    public JdbcUserPreferencesDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public UserPreferences getPreferencesId(int preference_id) {

        UserPreferences profile = new UserPreferences();
        String sql = "SELECT preference_id FROM  user_preferences WHERE preference_id=?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, preference_id);
        if (results.next()) {
            profile.setPreferencesId(results.getInt("preferences_id"));
        }

        return profile;
    }

    @Override
    public List<UserPreferences> getPreferencesByUserId(int userId) {

        List<UserPreferences> preferencesList = new ArrayList<>();
        String sql = "SELECT * FROM user_preferences WHERE user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while (results.next()) {
            UserPreferences preference = mapRowToUserPreferences(results);
            preferencesList.add(preference);
        }
        return preferencesList;
    }

    @Override
    public void setProfilePreferences(int userId, int homeZip, String preference) {
        String sql = "INSERT INTO user_preferences (user_id, home_zip, preference) VALUES ( " +
                     "(SELECT user_id FROM users WHERE user_id = ?), ?, ?)";
        jdbcTemplate.update(sql, userId, homeZip, preference);
    }

    @Override
    public List<UserPreferences> getAllPreferences() {
        List<UserPreferences> allPreferences = new ArrayList<>();
        UserPreferences preferences = new UserPreferences();
        String sql = "SELECT * FROM user_preference";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            preferences= mapRowToUserPreferences(results);
            allPreferences.add(preferences);
            
        }
        return allPreferences;
    }
    public UserPreferences mapRowToUserPreferences(SqlRowSet results) {

        UserPreferences user = new UserPreferences();
        user.setPreferencesId(results.getInt("preference_id"));
        user.setPreference(results.getString("preference"));
        user.setHomeZip(results.getInt("home_zip"));
        user.setUserId(results.getInt("user_id"));

        return user;
    }








}

