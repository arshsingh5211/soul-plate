package com.techelevator.model;

public class Preferences {

    private int userPreferencesId;
    private int userId;
    private int preferencesId;
    private String name;
    private String preference;
    private int homeZip;

    public int getUserPreferencesId() {
        return userPreferencesId;
    }

    public void setUserPreferencesId(int userPreferencesId) {
        this.userPreferencesId = userPreferencesId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPreferencesId() {
        return preferencesId;
    }

    public void setPreferencesId(int preferencesId) {
        this.preferencesId = preferencesId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }

    public int getHomeZip() {
        return homeZip;
    }

    public void setHomeZip(int homeZip) {
        this.homeZip = homeZip;
    }

    public Preferences(){ }



}
