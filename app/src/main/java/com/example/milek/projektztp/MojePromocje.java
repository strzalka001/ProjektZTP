package com.example.milek.projektztp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MojePromocje extends AppCompatActivity {

    private Sesja session;
    private Promocja aktualnaPromocja;
    private TextView txt;
    private UzytkownikDAO u;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moje_promocje);

        session = new Sesja(this);
        if (!session.loggedin()) {
            startActivity(new Intent(MojePromocje.this, MainActivity.class));
            finish();
        }
        u = new UzytkownikDAOimpl();
        aktualnaPromocja = new Promocja();
        aktualnaPromocja.zrobPromocje();

        txt = (TextView) findViewById(R.id.textView6);
        txt.setText(String.valueOf(aktualnaPromocja.pobierzPromocje()));
        //txt.setText(String.valueOf(u.aktualizujPromocje()));


    }
}
