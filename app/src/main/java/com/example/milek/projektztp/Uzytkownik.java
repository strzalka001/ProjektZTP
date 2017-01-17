package com.example.milek.projektztp;

import java.io.Serializable;

/**
 * Created by Paulina on 13.01.2017.
 */

public class Uzytkownik implements Serializable {

    public int id;
    public String email;
    public String haslo;

    public Uzytkownik() {
    }

    public Uzytkownik(int id, String email, String haslo) {
        this.id = id;
        this.email = email;
        this.haslo = haslo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String nazwa) {
        this.email = nazwa;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String opis) {
        this.haslo = opis;
    }
}
