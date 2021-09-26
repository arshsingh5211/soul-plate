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

    public JdbcUserPreferencesDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public UserPreferences getUserPreferences(int preferencesId) {
        UserPreferences userPreferences = null;
        String sql = "SELECT * FROM user_preferences WHERE preferences_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, preferencesId);
        if (results.next()) {
            userPreferences = mapRowToUserPreferences(results);
        }
        return userPreferences;
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
    public UserPreferences createProfilePreferences(UserPreferences newPreferences) {
        String query = "INSERT INTO user_preferences (user_id, name, home_zip, preference) VALUES ( " +
                     "(SELECT user_id FROM users WHERE user_id = ?), ?, ?, ?) RETURNING preferences_id;";
        Integer newId = jdbcTemplate.queryForObject(query, Integer.class, newPreferences.getUserId(),
                newPreferences.getName(), newPreferences.getHomeZip(), newPreferences.getPreference());
        return getUserPreferences(newId);
    }

    @Override
    public void updateProfilePreferences(UserPreferences updatedPreferences) {
        String query = "UPDATE user_preferences " +
                       "SET user_id = ?, name = ?, preference = ?, home_zip = ?, category_id = ? " +
                       "WHERE preferences_id = ?;";
        jdbcTemplate.update(query, updatedPreferences.getUserId(), updatedPreferences.getName(),
                updatedPreferences.getPreference(), updatedPreferences.getHomeZip(), updatedPreferences.getCategoryId(),
                updatedPreferences.getPreferencesId());
    }


    @Override
    public List<UserPreferences> getAllPreferences() {
        List<UserPreferences> allPreferences = new ArrayList<>();
        UserPreferences preferences = new UserPreferences();
        String sql = "SELECT * FROM user_preferences";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            preferences= mapRowToUserPreferences(results);
            allPreferences.add(preferences);
        }
        return allPreferences;
    }
    public UserPreferences mapRowToUserPreferences(SqlRowSet results) {

        UserPreferences userPreferences = new UserPreferences();
        userPreferences.setPreferencesId(results.getInt("preferences_id"));
        userPreferences.setPreference(results.getString("preference"));
        userPreferences.setName(results.getString("name"));
        userPreferences.setHomeZip(results.getInt("home_zip"));
        userPreferences.setUserId(results.getInt("user_id"));
        userPreferences.setCategoryId(results.getInt("category_id"));

        return userPreferences;
    }








}

