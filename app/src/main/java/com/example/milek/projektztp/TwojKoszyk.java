package com.example.milek.projektztp;

import java.util.ArrayList;

/**
 * Created by Milek on 2017-01-08.
 */

public class TwojKoszyk {

    private static ArrayList<Produkt> koszyk = new ArrayList<>();

    TwojKoszyk() {
    }

    public static ArrayList<Produkt> pobierzKoszyk() {
        return koszyk;
    }




    public static void WyczyscKoszyk() {
        koszyk.clear();


    }
}
