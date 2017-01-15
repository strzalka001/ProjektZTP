package com.example.milek.projektztp;

import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Paulina on 14.01.2017.
 */

public class Promocja implements IPromocja {

    public int znizkaPromo = 1;
    private ArrayList<UzytkownikDAO> listaUzytkownikow = new ArrayList<UzytkownikDAO>();


    public Promocja() {
        //istaUzytkownikow = new ArrayList<UzytkownikDAO>();
    }

    public void dodajObserwatora(UzytkownikDAO uzytkownik) {

        if (uzytkownik != null) {
            listaUzytkownikow.add(uzytkownik);
        }
    }

    public void usunObserwatora(UzytkownikDAO uzytkownik) {
        if (uzytkownik != null) {
            int index = listaUzytkownikow.indexOf(uzytkownik);
            listaUzytkownikow.remove(index);
        }
    }

    public void powiadomObserwatorow() {

        Log.d("Użytkownik: ", "weszlo");
        for (UzytkownikDAO u : listaUzytkownikow
                ) {
            Log.d("Użytkownik: ", u.toString());
            u.aktualizujPromocje();
        }
    }

    public void zrobPromocje(int a) {
        Random random = new Random();
        //this.znizkaPromo = random.nextInt((20 - 5) + 1)-5;
        this.znizkaPromo = a;
    }

    public int pobierzPromocje() {
        return znizkaPromo;
    }
}
