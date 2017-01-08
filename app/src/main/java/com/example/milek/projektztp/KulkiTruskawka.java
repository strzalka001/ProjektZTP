package com.example.milek.projektztp;

/**
 * Created by Milek on 2017-01-05.
 */

public class KulkiTruskawka extends Kulki {

    float cena = 2.2f;
    String opis = " Kulki Truskawka";

    Herbata herbata;

    public KulkiTruskawka(Herbata pHerbata) {
        super(pHerbata);
    }

    public float Cena() {
        return super.Cena() + cena;
    }

    public String Opis() {
        return super.Opis() + "\n " + opis;
    }

}