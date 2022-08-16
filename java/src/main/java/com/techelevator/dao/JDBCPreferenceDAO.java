package com.techelevator.dao;

import com.techelevator.model.Preference;
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
    public Preference getUserPreferences(int preferencesId) {
        Preference preference = null;
        String sql = "SELECT * FROM user_preferences WHERE preferences_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, preferencesId);
        if (results.next()) {
            preference = mapRowToUserPreferences(results);
        }
        return preference;
    }

    @Override
    public List<Preference> getPreferencesByUserId(int userId) {

        List<Preference> preferenceList = new ArrayList<>();
        String sql = "SELECT * FROM user_preferences WHERE user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while (results.next()) {
            Preference preference = mapRowToUserPreferences(results);
            preferenceList.add(preference);
        }
        return preferenceList;
    }

    @Override
    public Preference createProfilePreferences(Preference newPreference, int userId) {
        String query = "INSERT INTO user_preferences (user_id, preferences_id, name, home_zip) VALUES (" +
                     "(SELECT user_id FROM users WHERE user_id = ?), (SELECT preferences_id FROM preferences WHERE preferences_id = ?), ?, ?) ";
        Integer newPreferenceId = jdbcTemplate.queryForObject(query, Integer.class, userId,
                newPreference.getPreferencesId(), newPreference.getName(), newPreference.getHomeZip());
        return getUserPreferences(newPreferenceId);
    }

    // allow users to add more preferences not just replace when you choose new pref

    @Override
    public List<Preference> getAllPreferences() {
        List<Preference> allPreferences = new ArrayList<>();
        Preference preference = new Preference();
        String sql = "SELECT * FROM user_preferences";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            preference = mapRowToUserPreferences(results);
            allPreferences.add(preference);
        }
        return allPreferences;
    }
    public Preference mapRowToUserPreferences(SqlRowSet results) {

        Preference preference = new Preference();
        preference.setPreferencesId(results.getInt("preferences_id"));
        preference.setPreference(results.getString("preference"));
        preference.setName(results.getString("name"));
        preference.setHomeZip(results.getInt("home_zip"));
        preference.setUserId(results.getInt("user_id"));
        return preference;
    }








}

