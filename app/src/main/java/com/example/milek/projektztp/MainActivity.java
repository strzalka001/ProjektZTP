package com.example.milek.projektztp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button login;
    Button produkty;
    Button herbaty;
    Button koszyk;
    ArrayList<Produkt> kosz = new ArrayList<Produkt>();
    //BazaDanych baza = BazaDanych.PobierzBazeDanych(this, "baza1.db", null, 1);
    BazaDanych baza;



    private Button btnLogout;
    private Sesja session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        produkty = (Button) findViewById(R.id.buttonProdukty);
        herbaty = (Button) findViewById(R.id.buttonHerbaty);
        koszyk = (Button) findViewById(R.id.buttonKoszyk);
        login = (Button) findViewById(R.id.log);
        addListenerOnButtonProdukty();
        addListenerOnButtonHerbaty();
        addListenerOnButtonKoszyk();
        addListenerOnButtonLogowanie();
       // addListenerOnButtonWylogowanie();

        BazaDanych baza = new BazaDanych(this, "baza1.db", null, 1);

        //ProduktDAO db = new ProduktDAOimpl(this,baza);
        UzytkownikDAO db = new UzytkownikDAOimpl(this,baza);
        //db.open();
        db.openToWrite();

       // db.dodajProdukt("Jaśminowa kiwi", 7.4f , "Orzeźwiający napój na bazie zielonej herbaty jaśminowej o smaku kiwi");
        db.dodajUzytkownika("p","p");
        db.dodajUzytkownika("b","b");

        session = new Sesja(this);
        if (!session.loggedin()) {
            logout();
        }
        btnLogout = (Button) findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });

        kosz.add(new Produkt("colka", 3, "mniam"));

        // kosz = (ArrayList<Produkt>) getIntent().getSerializableExtra("kosz");
    }

    private void logout() {
        session.setLoggedin(false);
//        finish();
//        startActivity(new Intent(MainActivity.this, Logowanie.class));
    }

//    public void addListenerOnButtonWylogowanie() {
//        final Context context = this;
//        btnLogout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View arg0) {
//                logout();
//            }
//        });
//    }

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


}
