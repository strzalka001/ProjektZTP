package com.example.milek.projektztp;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class UzytkownikDAOimpl implements UzytkownikDAO {

    private static final String DEBUG_TAG = "SqLite";
    private static final int DB_WERSJA = 1;
    private static final String DB_NAZWA = "baza.db";

    private static final String TABELA_USER = "uzytkownicy";
    private static final String ID = "id";
    private static final String EMAIL = "email";
    private static final String HASLO = "haslo";

    private SQLiteDatabase db;
    private Context context;
    private BazaDanych baza;
    private Promocja mojaPromocja;
    private int mojaZnizka;

    public UzytkownikDAOimpl() {
    }

    public UzytkownikDAOimpl(Context context, BazaDanych baza,Promocja promocja) {
        this.baza = baza;
        this.context = context;
        this.mojaPromocja = promocja;
    }

    public void open() {
        //   baza = new BazaDanych
        try {
            db = baza.getWritableDatabase();
        } catch (SQLException e) {
            db = baza.getReadableDatabase();
        }
    }

    public void openToWrite() {
        db = baza.getWritableDatabase();
    }

    public void close() {
        baza.close();
    }

    public long dodajUzytkownika(String email, String haslo) {
        ContentValues nowyWiersz = new ContentValues();
        nowyWiersz.put(EMAIL, email);
        nowyWiersz.put(HASLO, haslo);
        return db.insert(TABELA_USER, null, nowyWiersz);
    }

    public long dodajUzytkownika(Uzytkownik uzytkownik) {
        ContentValues nowyWiersz = new ContentValues();
        nowyWiersz.put(EMAIL, uzytkownik.getEmail());
        nowyWiersz.put(HASLO, uzytkownik.getHaslo());
        return db.insert(TABELA_USER, null, nowyWiersz);
    }

    public Uzytkownik pobierzUzytkownika(int id) {
        String[] columns = {ID, EMAIL, HASLO};
        String where = ID + "=" + id;
        Cursor cursor = db.query(TABELA_USER, columns, where, null, null, null, null);
        Uzytkownik task = null;
        if (cursor != null && cursor.moveToFirst()) {
            String email = cursor.getString(1);
            String haslo = cursor.getString(2);

            task = new Uzytkownik(id, email, haslo);
        }
        return task;
    }


    //czy istnieje w bazie?
    public boolean pobierzUzytkownika(String email, String haslo) {

        String selectQuery = "select * from  " + TABELA_USER + " where " +
                EMAIL + " = " + "'" + email + "'" + " and " + HASLO + " = " + "'" + haslo + "'";

        SQLiteDatabase db = baza.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            return true;
        }

        cursor.close();
        db.close();

        return false;
    }


    public Cursor pobierzUzytkownikow() {
        String[] columns = {ID, EMAIL, HASLO};
        return db.query(TABELA_USER, new String[]{ID,
                EMAIL, HASLO}, null, null, null, null, null);
    }

    public List<Uzytkownik> pobierzListeUzytkownikow() {

        List<Uzytkownik> pom = new ArrayList<>();
        Cursor cursor = db.query(TABELA_USER, new String[]{ID,
                EMAIL, HASLO}, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                Uzytkownik uzytkownik = new Uzytkownik();
                uzytkownik.setId(Integer.parseInt(cursor.getString(0)));
                uzytkownik.setEmail(cursor.getString(1));
                uzytkownik.setHaslo(cursor.getString(2));

                pom.add(uzytkownik);
            } while (cursor.moveToNext());
        }
        return pom;
    }

    public boolean usunUzytkownika(long id) {
        String where = ID + "=" + id;
        return db.delete(TABELA_USER, where, null) > 0;
    }

    public int aktualizujPromocje() {
        mojaZnizka = mojaPromocja.pobierzPromocje();
        String pp = String.valueOf(mojaZnizka);
        Log.d("wartość w akt: ", pp);
        return mojaZnizka;
    }

    public int zwrocZnizke(){
        return mojaZnizka;
    }

}