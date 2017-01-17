package com.example.milek.projektztp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
            finish();
        }

        u = ((MyApplication) getApplication()).pobierzUsera();
        //aktualnaPromocja = ((MyApplication)getApplication()).pobierzPromocje();

        txt = (TextView) findViewById(R.id.textView6);
        txt.setText("Twoja zniżka wynosi obecnie " + String.valueOf(u.zwrocZnizke()) + "%");
        //txt.setText("Twoja zniżka wynosi obecnie " + String.valueOf(aktualnaPromocja.pobierzZnizke()) + "%");

    }
}