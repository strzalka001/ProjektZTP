package com.example.milek.projektztp;

import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Logowanie extends AppCompatActivity {
    private Button login, register;
    private EditText etEmail, etPass;
    BazaDanych baza = BazaDanych.PobierzBazeDanych(this, "baza.db", null, 1);
    private Sesja session;
    UzytkownikDAO db;
    Promocja promo = new Promocja();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logowanie);

        db = new UzytkownikDAOimpl(this,baza);
        db.open();

        session = new Sesja(this);
        login = (Button) findViewById(R.id.btnLogin);
        register = (Button) findViewById(R.id.btnReg);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPass = (EditText) findViewById(R.id.etPass);
        addListenerOnButtonRejestracja();
        addListenerOnButtonLogowanie();

        if (session.loggedin()) {
            //startActivity(new Intent(Logowanie.this, MainActivity.class));
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
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, Rejestracja.class);
                startActivity(intent);
            }
        });
    }

    private void login() {
        String email = etEmail.getText().toString();
        String pass = etPass.getText().toString();

        if (db.pobierzUzytkownika(email, pass)) {
            session.setLoggedin(true);
            //Log.d("niepowiadomieni","nielol");
            promo.powiadomObserwatorow();
            //Log.d("powiadomieni","lol");
            Toast.makeText(getApplicationContext(), "Zalogowano!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Logowanie.this, MainActivity.class));
            finish();
        } else {
            Toast.makeText(getApplicationContext(), "Niepoprawne dane", Toast.LENGTH_SHORT).show();
        }
    }
}
