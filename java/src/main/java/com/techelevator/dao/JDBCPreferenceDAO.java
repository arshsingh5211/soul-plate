package com.techelevator.dao;

import com.techelevator.model.Preferences;
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
    public Preferences getUserPreferences(int preferencesId) {
        Preferences preferences = null;
        String sql = "SELECT * FROM user_preferences WHERE preferences_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, preferencesId);
        if (results.next()) {
            preferences = mapRowToUserPreferences(results);
        }
        return preferences;
    }

    @Override
    public List<Preferences> getPreferencesByUserId(int userId) {

        List<Preferences> preferencesList = new ArrayList<>();
        String sql = "SELECT * FROM user_preferences WHERE user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while (results.next()) {
            Preferences preferences = mapRowToUserPreferences(results);
            preferencesList.add(preferences);
        }
        return preferencesList;
    }

    @Override
    public void createPreferences(Preferences newPreferences, int userId) {
        String query = "INSERT INTO preferences (preference, preferences_id) " +
                "VALUES (?, ?) ON CONFLICT (preferences_id) DO UPDATE " +
                "SET preference = excluded.preference " +
                "RETURNING preferences_id;";
        Integer prefId = jdbcTemplate.queryForObject(query, Integer.class, newPreferences.getPreference(),
                newPreferences.getPreferencesId());
        String query2 = "INSERT INTO user_preferences (user_id, preferences_id, name, home_zip) VALUES (" +
                "(SELECT user_id FROM users WHERE user_id = ?), (SELECT preferences_id FROM preferences WHERE " +
                "preferences_id = ?), ?, ?)";
        jdbcTemplate.update(query2, userId, prefId, newPreferences.getName(), newPreferences.getHomeZip());
    }

    // allow users to add more preferences not just replace when you choose new pref

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
        return preferences;
    }








}

