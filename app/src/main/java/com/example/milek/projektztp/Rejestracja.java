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

public class Rejestracja extends AppCompatActivity {

    private Button reg;
    private TextView tvLogin;
    private EditText etEmail, etPass;
    private String email, haslo;
    BazaDanych baza;
    UzytkownikDAO db;
    Promocja promo = new Promocja();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rejestracja);

        baza = BazaDanych.PobierzBazeDanych(this, "baza.db", null, 1);
        db = new UzytkownikDAOimpl(this, baza, promo);
        db.open();

        reg = (Button) findViewById(R.id.btnReg);
        tvLogin = (TextView) findViewById(R.id.tvLogin);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPass = (EditText) findViewById(R.id.etPass);
        addListenerOnButtonLogowanie();
        addListenerOnButtonRejestracja();
    }

    public void addListenerOnButtonRejestracja() {
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                zarejestruj();
            }
        });
    }

    public void addListenerOnButtonLogowanie() {
        final Context context = this;
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, Logowanie.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void zarejestruj() {
        email = etEmail.getText().toString();
        haslo = etPass.getText().toString();
        //Log.d("Email: ", email + " " + haslo);

        if (email.isEmpty() || haslo.isEmpty()) {
            wyswietlToast("Uzupełnij wszystkie pola");
        } else {
            db.dodajUzytkownika(email, haslo);
            promo.dodajObserwatora(db);
            wyswietlToast("Użytkownik zarejestrowany");
            finish();
        }
    }

    private void wyswietlToast(String komunikat) {
        Toast.makeText(getApplicationContext(), komunikat, Toast.LENGTH_SHORT).show();
    }
}
