package com.example.milek.projektztp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MojePromocje extends AppCompatActivity {

    private Sesja sesja;
    private Promocja aktualnaPromocja;
    private TextView txt;
    private UzytkownikDAO u;
    BazaDanych baza = BazaDanych.PobierzBazeDanych(this, "baza.db", null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moje_promocje);

        sesja = new Sesja(this);
        if (!sesja.loggedin()) {
            startActivity(new Intent(MojePromocje.this, MainActivity.class));
            finish();
        }

        aktualnaPromocja = new Promocja();
        u = new UzytkownikDAOimpl(this, baza, aktualnaPromocja);
        aktualnaPromocja.dodajObserwatora(u);

        aktualnaPromocja.zrobPromocje(20);
        aktualnaPromocja.pobierzPromocje();
        aktualnaPromocja.powiadomObserwatorow();


        txt = (TextView) findViewById(R.id.textView6);
        txt.setText("Twoja zniżka wynosi obecnie " + String.valueOf(u.zwrocZnizke()) + "%");
    }
}