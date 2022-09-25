package com.techelevator.dao;

import com.techelevator.model.Preferences;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
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
    public Preferences getPreference(int preferencesId) {
        Preferences preference = null;
        String sql = "SELECT preferences_id, user_preferences_id, preference, home_zip " +
                "FROM preferences JOIN user_preferences USING (preferences_id) " +
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
        String sql = "SELECT home_zip, user_preferences_id, preferences_id, preference FROM preferences JOIN user_preferences " +
                    "USING (preferences_id) " +
                    "JOIN users USING (user_id) WHERE user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while (results.next()) {
            Preferences preferences = mapRowToUserPreferences(results);
            preferencesList.add(preferences);
        }
        return preferencesList;
    }

//    @Override
//    public String createPreferences(Preferences newPreferences, int userId) {
//        try {
//            if (!doesPreferenceExistForUser(userId, newPreferences)) {
//                System.out.println("in if block");
//                String query = "INSERT INTO preferences (preference, home_zip) VALUES (?, ?) " +
//                        "ON CONFLICT (preference, home_zip) DO NOTHING " +
//                        "RETURNING preferences_id; ";
//                Integer preferencesId = jdbcTemplate.queryForObject(query, Integer.class, newPreferences.getPreference(),
//                        newPreferences.getHomeZip());
//                String query2 = "INSERT INTO user_preferences (user_id, preferences_id) VALUES (?, ?)";
//                jdbcTemplate.update(query2, userId, preferencesId);
//                System.out.println("IN CREATE PREFERENCES " + preferencesId);
//                getPreference(preferencesId);
//            }
//            System.out.println("outside of if block but in try block");
//            return "";
//        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
//            return "Sorry, that preference for " + userId + " already exists!";
//        }
//    }

    @Override
    public void createPreferences(Preferences newPreference, int userId) {
        try {
            String query = "INSERT INTO preferences (preference, home_zip) " +
                    "VALUES (?, ?) ON CONFLICT (preference, home_zip) DO NOTHING; ";
            jdbcTemplate.update(query, newPreference.getPreference(), newPreference.getHomeZip());
            System.out.println("does it get here?");
        } catch (DataAccessException dataAccessException) {
            System.err.println("Exception handling not the best way, queryForObject is generally discouraged " +
                    "because of data coupling to your data access implementation");
        }
        String query2 = "INSERT INTO user_preferences (user_id, preferences_id)" +
                "VALUES (?,(SELECT preferences_id FROM preferences WHERE preference = ? AND home_zip = ?));";
        jdbcTemplate.update(query2, userId, newPreference.getPreference(), newPreference.getHomeZip());
        System.out.println("what about here?");
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

    public boolean doesPreferenceExistForUser(int userId, Preferences preference) {
        List<Preferences> preferencesList = new ArrayList<>();
        String query = "SELECT user_id, preference FROM users " +
                "JOIN user_preferences USING (user_id) JOIN preferences USING (preferences_id) " +
                "WHERE user_id = ? AND preferences_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(query, userId, preference.getPreferencesId());
        while (results.next()) {
            Preferences preferences = mapRowToUserPreferences(results);
            preferencesList.add(preferences);
        }
        return preferencesList.size() > 0;
    }

    public Preferences mapRowToUserPreferences(SqlRowSet results) {

        Preferences preferences = new Preferences();
        preferences.setPreferencesId(results.getInt("preferences_id"));
        preferences.setUserPreferencesId(results.getInt("user_preferences_id"));
        preferences.setPreference(results.getString("preference"));
        preferences.setHomeZip(results.getString("home_zip"));

        return preferences;
    }








}

