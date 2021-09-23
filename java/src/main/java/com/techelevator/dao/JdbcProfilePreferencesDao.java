package com.techelevator.dao;

import com.techelevator.model.ProfilePreferences;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcProfilePreferencesDao implements ProfilePreferencesDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    JdbcProfilePreferencesDao profilePreferencesDao;

    public JdbcProfilePreferencesDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public ProfilePreferences getPreferencesId(int preference_id) {

        ProfilePreferences profile = new ProfilePreferences();
        String sql = "SELECT preference_id FROM  user_preferences WHERE preference_id=?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, preference_id);
        if (results.next()) {
            profile.setPreferencesId(results.getInt("preferences_id"));
        }

        return profile;
    }

    @Override
    public List<ProfilePreferences> getPreferencesByUserId(int userId) {

        List<ProfilePreferences> preferencesList = new ArrayList<>();
        String sql = "SELECT * FROM user_preferences WHERE user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while (results.next()) {
            ProfilePreferences preference = mapRowToProfilePreferences(results);
            preferencesList.add(preference);
        }
        return preferencesList;
    }

    private ProfilePreferences mapRowToProfilePreferences(SqlRowSet results) {

        ProfilePreferences profile = new ProfilePreferences();

        profile.setPreferencesId(results.getInt("preferences_id"));
        profile.setPreference(results.getString("preference"));
        profile.setHomeZip(results.getInt("home_zip"));
        profile.setUserId(results.getInt("user_id"));
        profile.setCategoryId(results.getInt("category_id"));

        return profile;
    }








}

