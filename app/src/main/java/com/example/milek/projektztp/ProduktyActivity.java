package com.example.milek.projektztp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ProduktyActivity extends AppCompatActivity {

    List products;
    ListView lvProducts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produkty);

        products = new ArrayList();
        ProduktDAO db = new ProduktDAOimpl(this);
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
                Produkt product =(Produkt) lvProducts.getItemAtPosition(position);
                // Toast.makeText(getApplicationContext(),product.getDesc(),Toast.LENGTH_LONG).show();
                //pole.setText(product.getDesc());
            }
        });






    }
}
