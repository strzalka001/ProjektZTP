package com.example.milek.projektztp;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Paulina on 14.01.2017.
 */

public class Promocja implements IPromocja {

    public int znizkaPromo = 10;
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

        for (UzytkownikDAO u:listaUzytkownikow
             ) {
            u.aktualizujPromocje();
        }
    }

    public void zrobPromocje(){
        Random random = new Random();
        znizkaPromo = random.nextInt((20 - 5) + 1) - 5;
    }

    public int pobierzPromocje() {
        return znizkaPromo;
    }


}
