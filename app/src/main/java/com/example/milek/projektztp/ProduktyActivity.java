package com.example.milek.projektztp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import com.example.milek.projektztp.BazaDanych;

public class ProduktyActivity extends AppCompatActivity {

    List products;
    ListView lvProducts;
    Button DodajDoKoszyka, ZobaczKoszyk;
    Produkt product= new Produkt("nazwa", 5, "opis");
    BazaDanych baza = BazaDanych.PobierzBazeDanych(this, "baza.db", null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produkty);
        DodajDoKoszyka = (Button) findViewById(R.id.buttonDodajDoKoszykZProduktow);
        ZobaczKoszyk = (Button) findViewById(R.id.buttonKoszykZProduktow);
        addListenerOnButtonDodajDoKoszyk();
        addListenerOnButtonZobaczKoszyk();


        products = new ArrayList();
        ProduktDAO db = new ProduktDAOimpl(this,baza);
        db.open();
        for (Produkt i : db.pobierzListeProduktow()) {
            db.usunProdukt(i.id);
        }

        db.dodajProdukt("sok", 4 , "Sok jest zdrowy");
        db.dodajProdukt("sok pomaranczowy", 3 , "Sok jest bardzo zdrowy");
        db.dodajProdukt("colka", 2 , "Colka jest pyszna");


        lvProducts = (ListView) findViewById( R.id.lista_produktow);
        //pole = (TextView) findViewById(R.id.textView4);
        lvProducts.setAdapter(new ListaAdapter(this, db.pobierzListeProduktow()));
        lvProducts.setClickable(true);



        lvProducts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 product =(Produkt) lvProducts.getItemAtPosition(position);
                // Toast.makeText(getApplicationContext(),product.getDesc(),Toast.LENGTH_LONG).show();
                //pole.setText(product.getDesc());
                DodajDoKoszyka.setEnabled(true);

            }
        });

    }

    public void addListenerOnButtonDodajDoKoszyk() {

        final Context context = this;
        DodajDoKoszyka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ArrayList<Produkt> kosz=null;
                kosz = TwojKoszyk.pobierzKoszyk();
                kosz.add(product);
                DodajDoKoszyka.setEnabled(false);

            }
        });
    }

    public void addListenerOnButtonZobaczKoszyk() {

        final Context context = this;
        ZobaczKoszyk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, KoszykActivity.class);
                startActivity(intent);
            }
        });
    }




}
