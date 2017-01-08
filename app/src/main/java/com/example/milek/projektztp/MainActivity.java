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

    Button produkty;
    Button herbaty;
    Button koszyk;
    ArrayList<Produkt> kosz = new ArrayList<Produkt>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        produkty = (Button) findViewById(R.id.buttonProdukty);
        herbaty = (Button) findViewById(R.id.buttonHerbaty);
        koszyk = (Button) findViewById(R.id.buttonKoszyk);
        addListenerOnButtonProdukty();
        addListenerOnButtonHerbaty();
        addListenerOnButtonKoszyk();



        kosz.add(new Produkt("colka", 3, "mniam"));

       // kosz = (ArrayList<Produkt>) getIntent().getSerializableExtra("kosz");



    }


    public void addListenerOnButtonProdukty() {
        final Context context = this;
        produkty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, ProduktyActivity.class);
                intent.putExtra("kosz",kosz);
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
                intent.putExtra("kosz",kosz);
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
                intent.putExtra("kosz",kosz);
                startActivity(intent);
            }
        });
    }






}
