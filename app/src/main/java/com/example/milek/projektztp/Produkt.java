package com.example.milek.projektztp;


import java.io.Serializable;

public class Produkt implements Serializable {

    private int id;
    private String nazwa;
    private float cena;
    private String opis;

    public Produkt() {
    }

    public Produkt(int id, String nazwa, float cena, String opis) {
        this.id = id;
        this.nazwa = nazwa;
        this.cena = cena;
        this.opis = opis;
    }

    public Produkt(String nazwa, float cena, String opis) {
        this.nazwa = nazwa;
        this.cena = cena;
        this.opis = opis;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public float getCena() {
        return cena;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}
