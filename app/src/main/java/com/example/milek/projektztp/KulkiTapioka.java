package com.example.milek.projektztp;

/**
 * Created by Milek on 2017-01-05.
 */

public class KulkiTapioka extends Kulki {

        float cena = 2f;
        String opis = " Kulki Tapioka";

        Herbata herbata;

public KulkiTapioka(Herbata pHerbata) {
        super(pHerbata);
        }

public float Cena() {
        return super.Cena() + cena;
        }

public String Opis() {
        return super.Opis() + "\n " + opis;
        }

        }