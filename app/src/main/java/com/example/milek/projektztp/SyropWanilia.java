package com.example.milek.projektztp;

/**
 * Created by Milek on 2017-01-05.
 */

public class SyropWanilia extends Syrop{

    float cena=1.1f;
    String opis = " Syrop Wanilia";

    Herbata herbata;

    public SyropWanilia(Herbata pHerbata){
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