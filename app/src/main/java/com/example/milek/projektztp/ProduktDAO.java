package com.example.milek.projektztp;

import android.database.Cursor;

import java.util.List;

/**
 * Created by Milek on 2017-01-04.
 */

public interface ProduktDAO {

    public void open();
    public void close();
    public long dodajProdukt(String nazwa, float cena, String opis);
    public long dodajProdukt(Produkt prod);
    public Produkt pobierzProdukt(int  id);
    public Cursor pobierzProdukty();
    public List<Produkt> pobierzListeProduktow();
    public boolean usunProdukt(long id);

}
