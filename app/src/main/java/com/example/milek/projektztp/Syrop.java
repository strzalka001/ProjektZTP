package com.example.milek.projektztp;

/**
 * Created by Milek on 2017-01-05.
 */

public class Syrop extends Herbata{

    Herbata herbata;

    public Syrop(Herbata pHerbata){
        this.herbata = pHerbata;
    }

    public  float Cena()
    {
        return herbata.Cena();
    }
    public  String Opis()
    {
        return herbata.Opis();
    }













}
