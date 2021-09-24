package com.techelevator.model;

public class UserPreferences {

    private int preferencesId;
    private int userId;
    private String preference;
    private  int homeZip;
    private int categoryId;

    public int getPreferencesId() {
        return preferencesId;
    }

    public void setPreferencesId(int preferencesId) {
        this.preferencesId = preferencesId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public UserPreferences(){ }



}
