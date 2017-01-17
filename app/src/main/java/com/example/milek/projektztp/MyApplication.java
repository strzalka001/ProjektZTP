package com.example.milek.projektztp;

import android.app.Application;
import android.content.res.Configuration;

/**
 * Created by Paulina on 17.01.2017.
 */

public class MyApplication extends Application {

    private static MyApplication singleton;

    private UzytkownikDAO mUzytkownik;
    private Promocja mPromocja;


    public static MyApplication getInstance() {
        return singleton;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public void zapiszUsera(UzytkownikDAO u) {
        this.mUzytkownik = u;
    }

    public UzytkownikDAO pobierzUsera() {
        return mUzytkownik;
    }

    public void zapiszPromocje(Promocja promocja) {
        this.mPromocja = promocja;
    }

    public Promocja pobierzPromocje() {
        return mPromocja;
    }

}
