package com.example.milek.projektztp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.milek.projektztp.R.id.btnPromo;

public class MainActivity extends AppCompatActivity {


    private Button produkty, herbaty, koszyk, promo;
    private Sesja mSessja;
    private ArrayList<Produkt> kosz = new ArrayList<Produkt>();
    private UzytkownikDAO u;
    private Promocja aktualnaPromocja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSessja = new Sesja(this);

        //jeśli użytkownik jest zalogowany
        if (mSessja.loggedin()) {

            aktualnaPromocja = ((MyApplication) getApplication()).pobierzPromocje();
            u = ((MyApplication) getApplication()).pobierzUsera();

            aktualnaPromocja.zrobPromocje(23);
            aktualnaPromocja.powiadomObserwatorow();

            ((MyApplication) getApplication()).zapiszUsera(u);
            ((MyApplication) getApplication()).zapiszPromocje(aktualnaPromocja);
        }

        produkty = (Button) findViewById(R.id.buttonProdukty);
        herbaty = (Button) findViewById(R.id.buttonHerbaty);
        koszyk = (Button) findViewById(R.id.buttonKoszyk);
        promo = (Button) findViewById(btnPromo);

        dodajListenerProdukty();
        dodajListenerHerbaty();
        dodajListenerKoszyk();
        dodajListenerPromocje();

        //dostępność przycisku promocje
        if (mSessja.loggedin()) {
            promo.setEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {

        switch (item.getItemId()) {
            case R.id.reg:
                Intent intent2 = new Intent(this, Logowanie.class);
                startActivity(intent2);
                break;
            case R.id.logout:
                wyloguj();
                finish();
                startActivity(getIntent());
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }

    private void wyloguj() {
        mSessja.setLoggedin(false);
        Toast.makeText(this, "Zaloguj się", Toast.LENGTH_SHORT).show();
        finish();
        startActivity(getIntent());
    }

    public void dodajListenerProdukty() {
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

    public void dodajListenerHerbaty() {
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

    public void dodajListenerKoszyk() {
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

    public void dodajListenerPromocje() {
        final Context context = this;
        promo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, MojePromocje.class);
                startActivity(intent);
            }
        });
    }

}