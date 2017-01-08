package com.example.milek.projektztp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

import java.util.ArrayList;

public class HerbatyActivity extends AppCompatActivity {

     Spinner rodzajHerbaty, rodzajSyropu, rodzajKulek;
     Button stworz, DodajDoKoszyka, ZobaczKoszyk;
     TextView kompozycja;
     String nazwa= " Własna Kompozycja";
     String opis = "opis";
     float cena = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_herbaty);


        addListenerOnButtonStworz();
        addListenerOnButtonKoszyk();
        addListenerOnButtonZobaczKoszyk();
    }

    public void addListenerOnButtonStworz() {

        rodzajHerbaty = (Spinner) findViewById(R.id.rodzaj_herbaty);
        rodzajSyropu = (Spinner) findViewById(R.id.rodzaj_syropu);
        rodzajKulek = (Spinner) findViewById(R.id.rodzaj_kulek);
        stworz = (Button) findViewById(R.id.stworz);
        kompozycja = (TextView) findViewById(R.id.kompozycja);




        stworz.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {


                stworz = (Button) findViewById(R.id.stworz);
                String rodzaj = String.valueOf(rodzajHerbaty.getSelectedItem());
                String syrop = String.valueOf(rodzajSyropu.getSelectedItem());
                String kulki = String.valueOf(rodzajKulek.getSelectedItem());

                Herbata h3 = new HerbataCzarna();
                if(rodzaj.compareTo("Czarna")==0 && syrop.compareTo("Brak")==0 && kulki.compareTo("Brak")==0 ){
                    h3 = new HerbataCzarna();}

                if(rodzaj.compareTo("Czarna")==0 && syrop.compareTo("Czekolada")==0 && kulki.compareTo("Brak")==0 ){
                    h3 = new SyropCzekolada(new HerbataCzarna());}

                if(rodzaj.compareTo("Czarna")==0 && syrop.compareTo("Liczi")==0 && kulki.compareTo("Brak")==0 ){
                    h3 = new SyropLiczi(new HerbataCzarna());}

                if(rodzaj.compareTo("Czarna")==0 && syrop.compareTo("Wanilia")==0 && kulki.compareTo("Brak")==0 ){
                    h3 = new SyropWanilia(new HerbataCzarna());}

                if(rodzaj.compareTo("Czarna")==0 && syrop.compareTo("Mango")==0 && kulki.compareTo("Brak")==0 ){
                    h3 = new SyropMango(new HerbataCzarna());}

                if(rodzaj.compareTo("Czarna")==0 && syrop.compareTo("Brak")==0 && kulki.compareTo("Tapioka")==0 ){
                    h3 = new KulkiTapioka(new HerbataCzarna());}

                if(rodzaj.compareTo("Czarna")==0 && syrop.compareTo("Brak")==0 && kulki.compareTo("Truskawka")==0 ){
                    h3 = new KulkiTruskawka(new HerbataCzarna());}
/////////
                if(rodzaj.compareTo("Czarna")==0 && syrop.compareTo("Czekolada")==0 && kulki.compareTo("Tapioka")==0 ){
                    h3 = new KulkiTapioka(new SyropCzekolada(new HerbataCzarna()));}

                if(rodzaj.compareTo("Czarna")==0 && syrop.compareTo("Liczi")==0 && kulki.compareTo("Tapioka")==0 ){
                    h3 = new KulkiTapioka(new SyropLiczi(new HerbataCzarna()));}

                if(rodzaj.compareTo("Czarna")==0 && syrop.compareTo("Wanilia")==0 && kulki.compareTo("Tapioka")==0 ){
                    h3 = new KulkiTapioka(new SyropWanilia(new HerbataCzarna()));}

                if(rodzaj.compareTo("Czarna")==0 && syrop.compareTo("Mango")==0 && kulki.compareTo("Tapioka")==0 ){
                    h3 = new KulkiTapioka(new SyropMango(new HerbataCzarna()));}
//////////
                if(rodzaj.compareTo("Czarna")==0 && syrop.compareTo("Czekolada")==0 && kulki.compareTo("Truskawka")==0 ){
                    h3 = new KulkiTruskawka(new SyropCzekolada(new HerbataCzarna()));}

                if(rodzaj.compareTo("Czarna")==0 && syrop.compareTo("Liczi")==0 && kulki.compareTo("Truskawka")==0 ){
                    h3 = new KulkiTruskawka(new SyropLiczi(new HerbataCzarna()));}

                if(rodzaj.compareTo("Czarna")==0 && syrop.compareTo("Wanilia")==0 && kulki.compareTo("Truskawka")==0 ){
                    h3 = new KulkiTruskawka(new SyropWanilia(new HerbataCzarna()));}

                if(rodzaj.compareTo("Czarna")==0 && syrop.compareTo("Mango")==0 && kulki.compareTo("Truskawka")==0 ){
                    h3 = new KulkiTruskawka(new SyropMango(new HerbataCzarna()));}





                if(rodzaj.compareTo("Zielona")==0 && syrop.compareTo("Brak")==0 && kulki.compareTo("Brak")==0 ){
                    h3 = new HerbataZielona();}

                if(rodzaj.compareTo("Zielona")==0 && syrop.compareTo("Czekolada")==0 && kulki.compareTo("Brak")==0 ){
                    h3 = new SyropCzekolada(new HerbataZielona());}

                if(rodzaj.compareTo("Zielona")==0 && syrop.compareTo("Liczi")==0 && kulki.compareTo("Brak")==0 ){
                    h3 = new SyropLiczi(new HerbataZielona());}

                if(rodzaj.compareTo("Zielona")==0 && syrop.compareTo("Wanilia")==0 && kulki.compareTo("Brak")==0 ){
                    h3 = new SyropWanilia(new HerbataZielona());}

                if(rodzaj.compareTo("Zielona")==0 && syrop.compareTo("Mango")==0 && kulki.compareTo("Brak")==0 ){
                    h3 = new SyropMango(new HerbataZielona());}

                if(rodzaj.compareTo("Zielona")==0 && syrop.compareTo("Brak")==0 && kulki.compareTo("Tapioka")==0 ){
                    h3 = new KulkiTapioka(new HerbataZielona());}

                if(rodzaj.compareTo("Zielona")==0 && syrop.compareTo("Brak")==0 && kulki.compareTo("Truskawka")==0 ){
                    h3 = new KulkiTruskawka(new HerbataZielona());}
/////////
                if(rodzaj.compareTo("Zielona")==0 && syrop.compareTo("Czekolada")==0 && kulki.compareTo("Tapioka")==0 ){
                    h3 = new KulkiTapioka(new SyropCzekolada(new HerbataZielona()));}

                if(rodzaj.compareTo("Zielona")==0 && syrop.compareTo("Liczi")==0 && kulki.compareTo("Tapioka")==0 ){
                    h3 = new KulkiTapioka(new SyropLiczi(new HerbataZielona()));}

                if(rodzaj.compareTo("Zielona")==0 && syrop.compareTo("Wanilia")==0 && kulki.compareTo("Tapioka")==0 ){
                    h3 = new KulkiTapioka(new SyropWanilia(new HerbataZielona()));}

                if(rodzaj.compareTo("Zielona")==0 && syrop.compareTo("Mango")==0 && kulki.compareTo("Tapioka")==0 ){
                    h3 = new KulkiTapioka(new SyropMango(new HerbataZielona()));}
//////////
                if(rodzaj.compareTo("Zielona")==0 && syrop.compareTo("Czekolada")==0 && kulki.compareTo("Truskawka")==0 ){
                    h3 = new KulkiTruskawka(new SyropCzekolada(new HerbataZielona()));}

                if(rodzaj.compareTo("Zielona")==0 && syrop.compareTo("Liczi")==0 && kulki.compareTo("Truskawka")==0 ){
                    h3 = new KulkiTruskawka(new SyropLiczi(new HerbataZielona()));}

                if(rodzaj.compareTo("Zielona")==0 && syrop.compareTo("Wanilia")==0 && kulki.compareTo("Truskawka")==0 ){
                    h3 = new KulkiTruskawka(new SyropWanilia(new HerbataZielona()));}

                if(rodzaj.compareTo("Zielona")==0 && syrop.compareTo("Mango")==0 && kulki.compareTo("Truskawka")==0 ){
                    h3 = new KulkiTruskawka(new SyropMango(new HerbataZielona()));}

/*
               Toast.makeText(HerbatyActivity.this,
                        "Twoja herbata : " +
                                "\nCena: "+ h3.Cena() + " zł" +
                                "\nSklad: "+ h3.Opis(),
                        Toast.LENGTH_SHORT).show();
*/
                kompozycja.setText("Twoja kompozycja: " +
                        "\nCena: "+ h3.Cena() + " zł" +
                        "\nSklad: \n"+ h3.Opis());
                opis = h3.Opis();
                cena = h3.Cena();

                DodajDoKoszyka = (Button) findViewById(R.id.button_dodaj_do_koszyka);
                DodajDoKoszyka.setEnabled(true);


            }
        });
    }

    public void addListenerOnButtonKoszyk() {

         DodajDoKoszyka = (Button) findViewById(R.id.button_dodaj_do_koszyka);
        kompozycja = (TextView) findViewById(R.id.kompozycja);

        final Context context = this;
        DodajDoKoszyka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ArrayList<Produkt> kosz=null;
                kosz = TwojKoszyk.pobierzKoszyk();

                kosz.add(new Produkt(nazwa, cena , opis));
               /* Toast.makeText(HerbatyActivity.this,
                        "Twoja herbata : " +
                                "\nnazwa: "+ nazwa  +
                                "\nCena: "+ cena + " zł" +
                                "\nopis: "+ opis,
                        Toast.LENGTH_SHORT).show();*/

                Toast.makeText(HerbatyActivity.this,
                        "Dodano do koszyka!",
                        Toast.LENGTH_SHORT).show();

                DodajDoKoszyka.setEnabled(false);
                kompozycja.setText("");

            }
        });
    }




    public void addListenerOnButtonZobaczKoszyk() {
        ZobaczKoszyk = (Button) findViewById(R.id.buttonZobaczKoszyk);
        final Context context = this;
        ZobaczKoszyk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, KoszykActivity.class);
                startActivity(intent);
            }
        });
    }











}
