package com.example.milek.projektztp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MojePromocje extends AppCompatActivity {

    private Sesja session;
    private Promocja aktualnaPromocja;
    private TextView txt;
    private UzytkownikDAO u;
    BazaDanych baza = BazaDanych.PobierzBazeDanych(this, "baza.db", null, 1);
    Promocja promo = new Promocja();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moje_promocje);

        session = new Sesja(this);
        if (!session.loggedin()) {
            startActivity(new Intent(MojePromocje.this, MainActivity.class));
            finish();
        }

        u = new UzytkownikDAOimpl(this, baza, promo);

        aktualnaPromocja = new Promocja();
        aktualnaPromocja.zrobPromocje(20);
        String p =String.valueOf(aktualnaPromocja.pobierzPromocje());
        Log.d("wartość zniżki 1: ",p);
        String pp =String.valueOf(u.aktualizujPromocje());
        Log.d("wartość zniżki 2: ",pp);
        aktualnaPromocja.powiadomObserwatorow();
        String ppp =String.valueOf(u.aktualizujPromocje());
        Log.d("wartość zniżki 3: ",ppp);

        txt = (TextView) findViewById(R.id.textView6);
        //txt.setText(String.valueOf(aktualnaPromocja.pobierzPromocje()));
        txt.setText("Twoja zniżka wynosi obecnie" + String.valueOf(u.aktualizujPromocje()) + "%");


    }
}
