package com.example.milek.projektztp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class KoszykActivity extends AppCompatActivity {

    ListView Listakoszyk;
    List koszyk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_koszyk);


        Listakoszyk = (ListView) findViewById( R.id.lista_koszyk);
        //pole = (TextView) findViewById(R.id.textView4);
        Listakoszyk.setAdapter(new ListaAdapter(this, TwojKoszyk.pobierzKoszyk()));
        Listakoszyk.setClickable(true);


        Listakoszyk.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Produkt product =(Produkt) Listakoszyk.getItemAtPosition(position);
                // Toast.makeText(getApplicationContext(),product.getDesc(),Toast.LENGTH_LONG).show();
                //pole.setText(product.getDesc());
            }
        });

    }






}












