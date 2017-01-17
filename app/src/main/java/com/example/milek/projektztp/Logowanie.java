package com.example.milek.projektztp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Logowanie extends AppCompatActivity {

    private Button login;
    private EditText etEmail, etPass;
    private TextView tvReg;
    private String email, haslo;
    private Sesja sesja;
    UzytkownikDAO db;
    BazaDanych baza = BazaDanych.PobierzBazeDanych(this, "baza.db", null, 1);
    Promocja promo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logowanie);

        promo = new Promocja();

        //promo = ((MyApplication)getApplication()).pobierzPromocje();
        db = new UzytkownikDAOimpl(this, baza, promo);


        db.open();

        sesja = new Sesja(this);
        login = (Button) findViewById(R.id.btnLogin);
        tvReg = (TextView) findViewById(R.id.tvReg);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPass = (EditText) findViewById(R.id.etPass);
        addListenerOnButtonRejestracja();
        addListenerOnButtonLogowanie();

        if (sesja.loggedin()) {
            finish();
        }
    }

    public void addListenerOnButtonLogowanie() {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                login();
            }
        });
    }

    public void addListenerOnButtonRejestracja() {
        final Context context = this;
        tvReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, Rejestracja.class);
                startActivity(intent);
            }
        });
    }

    private void login() {
        email = etEmail.getText().toString();
        haslo = etPass.getText().toString();

        if (db.pobierzUzytkownika(email, haslo)) {
            sesja.setLoggedin(true);
            promo.dodajObserwatora(db);
            ((MyApplication)getApplication()).zapiszUsera(db);
            ((MyApplication)getApplication()).zapiszPromocje(promo);

            Toast.makeText(getApplicationContext(), "Zalogowano", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Logowanie.this, MainActivity.class));
            finish();

        } else {
            Toast.makeText(getApplicationContext(), "Niepoprawne dane", Toast.LENGTH_SHORT).show();
        }
    }
}
