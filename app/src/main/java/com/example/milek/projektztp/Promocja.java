package com.example.milek.projektztp;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Paulina on 14.01.2017.
 */

public class Promocja implements IPromocja {

    private int mZnizka = 1;
    private ArrayList<UzytkownikDAO> listaUzytkownikow = new ArrayList<>();

    public Promocja() {

    }

    public void dodajObserwatora(UzytkownikDAO u) {
        listaUzytkownikow.add(u);
    }

    public void usunObserwatora(UzytkownikDAO u) {
        listaUzytkownikow.remove(u);
    }

    public void powiadomObserwatorow() {

        for (UzytkownikDAO u : listaUzytkownikow
                ) {
            u.aktualizujPromocje();
        }
    }

    public void zrobPromocje(int a) {
        this.mZnizka = a;
    }

    public int pobierzZnizke() {
        return mZnizka;
    }
}
