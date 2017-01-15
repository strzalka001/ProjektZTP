package com.example.milek.projektztp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button login,produkty,herbaty,koszyk,promo,los,btnLogout;
    private Promocja aktualnaPromocja = new Promocja();
    private Sesja sesja;
    private ArrayList<Produkt> kosz = new ArrayList<Produkt>();
    BazaDanych baza = BazaDanych.PobierzBazeDanych(this, "baza.db", null, 1);
    UzytkownikDAO u;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aktualnaPromocja = new Promocja();
        u = new UzytkownikDAOimpl(this, baza, aktualnaPromocja);

        sesja = new Sesja(this);

        produkty = (Button) findViewById(R.id.buttonProdukty);
        herbaty = (Button) findViewById(R.id.buttonHerbaty);
        koszyk = (Button) findViewById(R.id.buttonKoszyk);
        login = (Button) findViewById(R.id.log);
        promo=(Button)findViewById(R.id.promo);
        los=(Button)findViewById(R.id.button123);
        btnLogout = (Button) findViewById(R.id.btnLogout);

        addListenerOnButtonProdukty();
        addListenerOnButtonHerbaty();
        addListenerOnButtonKoszyk();
        addListenerOnButtonLogowanie();
        addListenerOnButtonPromo();
        addListenerOnButtonLos();

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });

        if (!sesja.loggedin()) {
            logout();
            Toast.makeText(this,"Wylogowano",Toast.LENGTH_SHORT).show();
        }
    }

    private void logout() {
        sesja.setLoggedin(false);
    }

    public void addListenerOnButtonLogowanie() {
        final Context context = this;
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, Logowanie.class);
                intent.putExtra("kosz", kosz);
                startActivity(intent);
            }
        });
    }


    public void addListenerOnButtonProdukty() {
        final Context context = this;
        produkty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, ProduktyActivity.class);
                intent.putExtra("kosz", kosz);
                startActivity(intent);
            }
        });
    }

    public void addListenerOnButtonHerbaty() {
        final Context context = this;
        herbaty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, HerbatyActivity.class);
                intent.putExtra("kosz", kosz);
                startActivity(intent);
            }
        });
    }

    public void addListenerOnButtonKoszyk() {
        final Context context = this;
        koszyk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, KoszykActivity.class);
                intent.putExtra("kosz", kosz);
                startActivity(intent);
            }
        });
    }

    public void addListenerOnButtonPromo() {
        final Context context = this;
        promo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, MojePromocje.class);
                startActivity(intent);
            }
        });
    }

    public void addListenerOnButtonLos() {
        final Context context = this;
        los.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                aktualnaPromocja.zrobPromocje(20);
                //u.aktualizujPromocje(aktualnaPromocja);
                aktualnaPromocja.powiadomObserwatorow();
            }
        });
    }
}