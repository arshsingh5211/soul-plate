package com.techelevator.model;

public class UserPreferences {
    private int userPreferencesId;
    private int userId;
    private int preferencesId;
    private String name;
    private String homeZip;

    public UserPreferences(){ }

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

    public String getHomeZip() {
        return homeZip;
    }

    public void setHomeZip(String homeZip) {
        this.homeZip = homeZip;
    }
}
