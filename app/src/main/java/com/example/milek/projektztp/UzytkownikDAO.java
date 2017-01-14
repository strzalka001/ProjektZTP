package com.example.milek.projektztp;

import android.database.Cursor;

import java.util.List;

/**
 * Created by Paulina on 13.01.2017.
 */

public interface UzytkownikDAO {

    public void open();

    public void openToWrite();

    public void close();

    public long dodajUzytkownika(String email, String haslo);

    public long dodajUzytkownika(Uzytkownik u);

    public Uzytkownik pobierzUzytkownika(int id);

    public boolean pobierzUzytkownika(String email, String haslo);

    public Cursor pobierzUzytkownikow();

    public List<Uzytkownik> pobierzListeUzytkownikow();

    public boolean usunUzytkownika(long id);

    public void aktualizujPromocje();

}
