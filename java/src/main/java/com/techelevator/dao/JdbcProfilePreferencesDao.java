package com.techelevator.dao;

import com.techelevator.model.ProfilePreferences;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
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
        String sql = "SELECT preference_id FROM  profile_preferences WHERE preference_id=?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, preference_id);
        if (results.next()) {
            profile.setPreferences_id(results.getInt("preferences_id"));
        }

        return profile;
    }

    @Override
    public List<ProfilePreferences> getPreferencesByUserId(int userId) {

        List<ProfilePreferences> preferencesList = new ArrayList<>();
        String sql = "SELECT * FROM profile_preferences WHERE user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while (results.next()) {
            ProfilePreferences preference = mapRowToProfilePreferences(results);
            preferencesList.add(preference);
        }
        return preferencesList;
    }

    private ProfilePreferences mapRowToProfilePreferences(SqlRowSet results) {

        ProfilePreferences profile = new ProfilePreferences();

        profile.setPreferences_id(results.getInt("preferences_id"));
        profile.setPreference(results.getString("preference"));
        profile.setHome_zip(results.getInt("home_zip"));
        profile.setUser_id(results.getInt("user_id"));
        profile.setCategory_id(results.getInt("category_id"));

        return profile;
    }








}

