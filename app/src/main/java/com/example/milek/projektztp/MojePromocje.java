package com.example.milek.projektztp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MojePromocje extends AppCompatActivity {

    private Sesja mSesja;
    private TextView mTekst;
    private UzytkownikDAO uzytkownik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moje_promocje);

        mSesja = new Sesja(this);
        if (!mSesja.loggedin()) {
            finish();
        }

        uzytkownik = ((MyApplication) getApplication()).pobierzUsera();

        mTekst = (TextView) findViewById(R.id.textView6);
        mTekst.setText("Twoja zniżka wynosi obecnie " + String.valueOf(uzytkownik.zwrocZnizke()) + "%");

    }
}