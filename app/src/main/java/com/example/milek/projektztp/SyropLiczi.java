package com.example.milek.projektztp;

/**
 * Created by Milek on 2017-01-05.
 */

public class SyropLiczi extends Syrop{

    float cena=1.5f;
    String opis = " Syrop Liczi";

    Herbata herbata;

    public SyropLiczi(Herbata pHerbata){
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
