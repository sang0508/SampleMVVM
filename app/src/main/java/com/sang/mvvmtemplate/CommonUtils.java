package com.sang.mvvmtemplate;

import android.content.Context;
import android.content.SharedPreferences;

public class CommonUtils {
    private static final String PREF_FILE = "pref-saving";
    private static CommonUtils instance;

    public static CommonUtils getInstance() {
        if (instance == null) {
            instance = new CommonUtils();
        }
        return instance;
    }

    public void savePref(String key, String value){
        SharedPreferences sharedPreferences = App.getInstance().getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE);
        sharedPreferences.edit().putString(key, value).apply();
    }

    public String getPref(String key){
        SharedPreferences sharedPreferences = App.getInstance().getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE);
        return sharedPreferences.getString(key, null);
    }

    public void clearPref(String key){
        SharedPreferences sharedPreferences = App.getInstance().getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE);
        sharedPreferences.edit().remove(key).apply();
    }

}
