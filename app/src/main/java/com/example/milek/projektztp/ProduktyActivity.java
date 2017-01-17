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

    private List products, dayproducts;
    private ListView lvProducts;
    private ProduktDAO db;
    private Button DodajDoKoszyka, ZobaczKoszyk, ProduktyDnia;
    private Produkt product= new Produkt("nazwa", 5, "opis");
    private BazaDanych baza = BazaDanych.PobierzBazeDanych(this, "baza.db", null, 1);
    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produkty);
        DodajDoKoszyka = (Button) findViewById(R.id.buttonDodajDoKoszykZProduktow);
        ZobaczKoszyk = (Button) findViewById(R.id.buttonKoszykZProduktow);
        ProduktyDnia = (Button) findViewById(R.id.buttonProduktyDnia);
        DodajListenerDodawanieDoKoszyka();
        DodajListenerPodgladKoszyka();
        DodajListenerProduktyDnia();


        products = new ArrayList();
        dayproducts = new ArrayList<Produkt>();

        db = new ProduktDAOimpl(this,baza);
        db.open();
         for (Produkt i : db.pobierzListeProduktow()) {
           db.usunProdukt(i.getId());
       }

        db.dodajProdukt("Jaśminowa kiwi", 7.4f , "Orzeźwiający napój na bazie zielonej herbaty jaśminowej o smaku kiwi");
        db.dodajProdukt("Czarna brzoskwinia", 8.3f , "Herbata czarna z brzoskwinią z żelkami winogronowymi");
        db.dodajProdukt("Oolong Choco", 8.2f , "Bubble Tea na bazie herbaty Oolong z czekoladą, mlekiem i z tapioką");
        db.dodajProdukt("Japońska Matcha", 9.2f , "Zielona japońska herbata Matcha doskonale smakuje w wersji mrożonej z mlekiem");
        db.dodajProdukt("Jaśminowy Piernik", 9.8f , "Rozgrzewająca Bubble Tea? Jaśminowa herbata z mieszanką piernikową, z cytryną i z żelkami liczi");
        db.dodajProdukt("Jaśminowa kiwi2", 7.4f , "Orzeźwiający napój na bazie zielonej herbaty jaśminowej o smaku kiwi");
        db.dodajProdukt("Czarna brzoskwinia2", 8.3f , "Herbata czarna z brzoskwinią z żelkami winogronowymi");
        db.dodajProdukt("Oolong Choco2", 8.2f , "Bubble Tea na bazie herbaty Oolong z czekoladą, mlekiem i z tapioką");
        db.dodajProdukt("Japońska Matcha2", 9.2f , "Zielona japońska herbata Matcha doskonale smakuje w wersji mrożonej z mlekiem");
        db.dodajProdukt("Jaśminowy Piernik2", 9.8f , "Rozgrzewająca Bubble Tea? Jaśminowa herbata z mieszanką piernikową, z cytryną i z żelkami liczi");

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

    public void DodajListenerDodawanieDoKoszyka() {

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

    public void DodajListenerPodgladKoszyka() {

        final Context context = this;
        ZobaczKoszyk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, KoszykActivity.class);
                startActivity(intent);
            }
        });
    }


    public void DodajListenerProduktyDnia() {

        ProduktyDnia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                dayproducts.clear();
                lvProducts.setAdapter(null);
                IteratorProduktow iterator = new IteratorProduktow(db.pobierzListeProduktow());

                while(iterator.hasNext()){
                    Produkt it = iterator.next();
                    if(it.getNazwa().compareTo("brak")!=0) dayproducts.add(it);
                }
                lvProducts.setAdapter(new ListaAdapter(context,dayproducts));

            }
        });
    }



}
