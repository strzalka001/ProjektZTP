package com.example.milek.projektztp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button produkty, herbaty, koszyk, promo, los;
    private Promocja aktualnaPromocja = new Promocja();
    private Sesja sesja;
    private ArrayList<Produkt> kosz = new ArrayList<Produkt>();
    private UzytkownikDAO u;
    BazaDanych baza = BazaDanych.PobierzBazeDanych(this, "baza.db", null, 1);


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

        addListenerOnButtonProdukty();
        addListenerOnButtonHerbaty();
        addListenerOnButtonKoszyk();

        if (!sesja.loggedin()) {
            logout();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {

        switch (item.getItemId()) {
            case R.id.reg:
                Intent intent2 = new Intent(this, Logowanie.class);
                startActivity(intent2);
                break;
            case R.id.logout:
                logout();
                break;
            case R.id.promocja:
                idzDoMojePromocje(this.findViewById(R.id.promocja));
                break;
            case R.id.onas:
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return super.onOptionsItemSelected(item);
    }

    private void logout() {

        sesja.setLoggedin(false);
        Toast.makeText(this, "Zaloguj się", Toast.LENGTH_SHORT).show();
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


    public void idzDoMojePromocje(View view) {
        Intent intent = new Intent(this, MojePromocje.class);
        startActivity(intent);
    }
}