package com.techelevator.model;

public class Preferences {

    private int preferencesId;
    private int userPreferencesId;
    private String preference;
    private String homeZip;


    public Preferences(){ }

    public int getPreferencesId() {
        return preferencesId;
    }

    public void setPreferencesId(int preferencesId) {
        this.preferencesId = preferencesId;
    }

    public int getUserPreferencesId() {
        return userPreferencesId;
    }

    public void setUserPreferencesId(int userPreferencesId) {
        this.userPreferencesId = userPreferencesId;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }

    public String getHomeZip() {
        return homeZip;
    }

    public void setHomeZip(String homeZip) {
        this.homeZip = homeZip;
    }

    public String toString() {
        String id = String.valueOf(getPreferencesId());
        String userPrefId = String.valueOf(userPreferencesId);
        String pref = preference;
        String zip = homeZip;

        return "User ID: " + id + "\nUser Preferences ID: " + userPrefId + "\nPreference: " + pref + "\nHomeZip: " + zip;
    }
}
