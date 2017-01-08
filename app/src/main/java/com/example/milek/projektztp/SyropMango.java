package com.example.milek.projektztp;

/**
 * Created by Milek on 2017-01-05.
 */

public class SyropMango extends Syrop{

    float cena=1.2f;
    String opis = " Syrop Mango";

    Herbata herbata;

    public SyropMango(Herbata pHerbata){
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
