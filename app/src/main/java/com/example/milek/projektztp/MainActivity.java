package com.example.milek.projektztp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button produkty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        produkty = (Button) findViewById(R.id.buttonProdukty);
        addListenerOnButtonProdukty();
    }


    public void addListenerOnButtonProdukty() {
        final Context context = this;
        produkty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, ProduktyActivity.class);
                startActivity(intent);
            }
        });
    }







}
