package com.techelevator.dao;

import com.techelevator.model.Preferences;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class JDBCPreferenceDAO implements PreferenceDAO {
    private JdbcTemplate jdbcTemplate;

    public JDBCPreferenceDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Preferences getPreference(int preferencesId, int userPreferencesId) {
        Preferences preference = null;
        String sql = "SELECT preferences_id, user_preferences_id, preference, name, home_zip " +
                "FROM preferences JOIN user_preferences USING preferences_id " +
                "WHERE preferences_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, preferencesId);
        while (results.next()) {
            preference = mapRowToUserPreferences(results);
        }
        return preference;
    }

    @Override
    public List<Preferences> getPreferencesByUserId(int userId) {
        List<Preferences> preferencesList = new ArrayList<>();
        String sql = "SELECT name, home_zip, user_preferences_id, preferences_id, preference FROM preferences JOIN user_preferences " +
                "USING (preferences_id) " +
                "JOIN users USING (user_id) WHERE user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while (results.next()) {
            Preferences preferences = mapRowToUserPreferences(results);
            preferencesList.add(preferences);
        }
        return preferencesList;
    }

    @Override
    public Preferences createPreferences(Preferences newPreferences, int userId) {
        try {
            String query = "INSERT INTO preferences (preference, home_zip) VALUES (?, ?) " +
                    "ON CONFLICT DO NOTHING " +
                    "RETURNING preferences_id; ";
            Integer preferencesId = jdbcTemplate.queryForObject(query, Integer.class, newPreferences.getPreference(),
                    newPreferences.getHomeZip());
            String query2 = "INSERT INTO user_preferences (user_id, preferences_id, name) VALUES (?, ?, ?) " +
                    "ON CONFLICT (user_preferences_id) DO NOTHING RETURNING user_preferences_id";
            Integer userPreferencesId = jdbcTemplate.queryForObject(query2, Integer.class, userId, preferencesId, newPreferences.getName());
            return getPreference(preferencesId, userPreferencesId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Preferences> getAllPreferences() {
        List<Preferences> allPreferences = new ArrayList<>();
        Preferences preferences = new Preferences();
        String sql = "SELECT * FROM user_preferences";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            preferences = mapRowToUserPreferences(results);
            allPreferences.add(preferences);
        }
        return allPreferences;
    }
    public Preferences mapRowToUserPreferences(SqlRowSet results) {

        Preferences preferences = new Preferences();
        preferences.setPreferencesId(results.getInt("preferences_id"));
        preferences.setUserPreferencesId(results.getInt("user_preferences_id"));
        preferences.setPreference(results.getString("preference"));
        preferences.setName(results.getString("name"));
        preferences.setHomeZip(results.getString("home_zip"));

        return preferences;
    }








}

