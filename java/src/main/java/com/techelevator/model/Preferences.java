package com.techelevator.model;

public class Preferences {

    private int preferencesId;
    private String preference;

    public Preferences(){ }

    public int getPreferencesId() {
        return preferencesId;
    }

    public void setPreferencesId(int preferencesId) {
        this.preferencesId = preferencesId;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }

}
