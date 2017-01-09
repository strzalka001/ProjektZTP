package com.example.milek.projektztp;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ProduktDAOimpl implements ProduktDAO {

    private static final String DEBUG_TAG = "SqLite";
    private static final int DB_WERSJA = 1;
    private static final String DB_NAZWA = "baza.db";
    private static final String TABELA_PRODUKT = "produkty";
    private static final String PRODUKT_ID = "id";
    private static final String PRODUKT_NAZWA = "nazwa";
    private static final String PRODUKT_CENA = "cena";
    private static final String PRODUKT_OPIS = "opis";

    private SQLiteDatabase db;
    private Context context;
    private BazaDanych baza;


    public ProduktDAOimpl() {}

    public ProduktDAOimpl(Context context, BazaDanych baza) {
        this.baza=baza;
        this.context = context;
    }


    public void open(){
     //   baza = new BazaDanych
        try {
            db = baza.getWritableDatabase();
        } catch (SQLException e) {
            db = baza.getReadableDatabase();
        }

    }

    public void close() {
        baza.close();
    }
    ///////////////////////////////// DODAWANIE PRODUKTOW DO BAZY   ////////////////////////////////
    public long dodajProdukt(String nazwa, float cena, String opis) {
        ContentValues nowyWiersz = new ContentValues();
        nowyWiersz.put(PRODUKT_NAZWA, nazwa);
        nowyWiersz.put(PRODUKT_CENA, cena);
        nowyWiersz.put(PRODUKT_OPIS, opis);
        return db.insert(TABELA_PRODUKT, null, nowyWiersz);
    }

    public long dodajProdukt(Produkt prod) {
        ContentValues nowyWiersz = new ContentValues();
        nowyWiersz.put(PRODUKT_NAZWA, prod.getNazwa());
        nowyWiersz.put(PRODUKT_CENA, prod.getCena());
        nowyWiersz.put(PRODUKT_OPIS, prod.getOpis());
        return db.insert(TABELA_PRODUKT, null, nowyWiersz);
    }


    //////////////////////////////  POBIERANIE PRODUKTOW Z BAZY ////////////////////////////////////
    public Produkt pobierzProdukt(int  id) {
        String[] columns = {PRODUKT_ID, PRODUKT_NAZWA,PRODUKT_CENA, PRODUKT_OPIS};
        String where = PRODUKT_ID + "="+id;
        Cursor cursor = db.query(TABELA_PRODUKT, columns, where, null, null, null, null);
        Produkt task = null;
        if(cursor != null && cursor.moveToFirst()) {
            String nazwa = cursor.getString(1);
            String cena = cursor.getString(2);
            String opis = cursor.getString(3);

            task = new Produkt(id, nazwa, Float.parseFloat(cena),opis);
        }
        return task;
    }

    public Cursor pobierzProdukty() {
        String[] columns = {PRODUKT_ID, PRODUKT_NAZWA, PRODUKT_CENA, PRODUKT_OPIS};
        return db.query(TABELA_PRODUKT,new String[] { PRODUKT_ID,
                PRODUKT_NAZWA, PRODUKT_CENA , PRODUKT_OPIS }, null, null, null, null, null);
    }


    public List<Produkt> pobierzListeProduktow() {

        List<Produkt> pom =new ArrayList<Produkt>();
        Cursor cursor = db.query(TABELA_PRODUKT,new String[] { PRODUKT_ID,
                PRODUKT_NAZWA, PRODUKT_CENA , PRODUKT_OPIS }, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                Produkt item = new Produkt();
                item.setId(Integer.parseInt(cursor.getString(0)));
                item.setNazwa(cursor.getString(1));
                item.setCena(Float.parseFloat(cursor.getString(2)));
                item.setOpis(cursor.getString(3));

                // Adding contact to list
                pom.add(item);
            } while (cursor.moveToNext());
        }
        return pom;
    }

    /////////////////////// USUWANIE PRODUKTOW //////////////////////////////////////////////////////
    public boolean usunProdukt(long id) {
        String where = PRODUKT_ID + "=" + id;
        return db.delete(TABELA_PRODUKT, where, null) > 0;
    }

















}
