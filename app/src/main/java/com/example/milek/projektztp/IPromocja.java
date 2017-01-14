package com.example.milek.projektztp;

/**
 * Created by Paulina on 14.01.2017.
 */

public interface IPromocja {

    public void dodajObserwatora(UzytkownikDAO u);

    public void usunObserwatora(UzytkownikDAO u);

    public void powiadomObserwatorow();
}
