package com.example.milek.projektztp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MojePromocje extends AppCompatActivity {

    private Sesja session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moje_promocje);

        session = new Sesja(this);
        if (!session.loggedin()) {
            startActivity(new Intent(MojePromocje.this, MainActivity.class));
            finish();
        }
    }
}
