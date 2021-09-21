package com.techelevator.model;

public class ProfilePreferences {

    private int preferences_id;

    public int getPreferences_id() {
        return preferences_id;
    }

    public void setPreferences_id(int preferences_id) {
        this.preferences_id = preferences_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }

    public int getHome_zip() {
        return home_zip;
    }

    public void setHome_zip(int home_zip) {
        this.home_zip = home_zip;
    }

    private int user_id;
    private String preference;
    private  int home_zip;
    public ProfilePreferences(){

    }

}
