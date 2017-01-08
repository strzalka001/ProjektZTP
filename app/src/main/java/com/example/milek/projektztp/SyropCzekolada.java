package com.example.milek.projektztp;

/**
 * Created by Milek on 2017-01-05.
 */

public class SyropCzekolada extends Syrop{

    float cena=1f;
    String opis = " Syrop Czekoladowy";

    Herbata herbata;

    public SyropCzekolada(Herbata pHerbata){
        super(pHerbata);
    }

    public  float Cena()
    {
        return super.Cena() + cena;
    }
    public  String Opis()
    {
        return super.Opis() + "\n " + opis;
    }



}
