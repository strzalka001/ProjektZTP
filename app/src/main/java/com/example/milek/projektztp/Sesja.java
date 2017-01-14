package com.example.milek.projektztp;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Paulina on 13.01.2017.
 */

public class Sesja {
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Context context;

    public Sesja(Context context) {
        this.context = context;
        prefs = context.getSharedPreferences("projektZTP", Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    public void setLoggedin(boolean logggedin) {
        editor.putBoolean("loggedInmode", logggedin);
        editor.commit();
    }

    public boolean loggedin() {
        return prefs.getBoolean("loggedInmode", false);
    }
}