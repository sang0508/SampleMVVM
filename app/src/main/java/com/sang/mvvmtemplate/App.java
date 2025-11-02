package com.sang.mvvmtemplate;

import android.app.Application;

import androidx.room.Room;

public class App extends Application {
    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
//        initDB();
    }

//    private void initDB() {
//        db = Room.databaseBuilder(getApplicationContext(), UserDB.class, "db-name").build();
//    }
//
//    public UserDB getDb() {
//        return db;
//    }




    public static App getInstance() {
        return instance;
    }


}
