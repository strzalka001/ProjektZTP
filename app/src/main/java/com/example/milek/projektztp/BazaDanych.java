package com.example.milek.projektztp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class BazaDanych extends SQLiteOpenHelper {


    private static BazaDanych bazadanych;





    private static final String DEBUG_TAG = "SqLite";
    private static final int DB_WERSJA = 1;
    private static final String DB_NAZWA = "baza.db";
    private static final String TABELA_PRODUKT = "produkty";


    private static final String PRODUKT_ID = "id";
    private static final String PRODUKT_NAZWA = "nazwa";
    private static final String PRODUKT_CENA = "cena";
    private static final String PRODUKT_OPIS = "opis";

    String UTWORZ_TABELA_PRODUKT = "CREATE TABLE " + TABELA_PRODUKT + "("
            + PRODUKT_ID + " INTEGER PRIMARY KEY," + PRODUKT_NAZWA + " TEXT,"
            + PRODUKT_CENA + " TEXT," + PRODUKT_OPIS + " TEXT" + ");";

    String USUN_TABELA_PRODUKT =
            "DROP TABLE IF EXISTS " + TABELA_PRODUKT;




    public BazaDanych(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {

      super(context, name, factory, version);

    }


    public static BazaDanych PobierzBazeDanych(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {


        if (bazadanych==null)
        {
            bazadanych = new BazaDanych(context, name, factory, version);
            return bazadanych;
        }
        else return bazadanych;
    }








    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(UTWORZ_TABELA_PRODUKT);

        Log.d(DEBUG_TAG, "Database creating...");
        Log.d(DEBUG_TAG, "Table " + TABELA_PRODUKT + " ver." + DB_WERSJA + " created");
    }




    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(USUN_TABELA_PRODUKT);

        Log.d(DEBUG_TAG, "Database updating...");
        Log.d(DEBUG_TAG, "Table " + TABELA_PRODUKT + " updated from ver." + oldVersion + " to ver." + newVersion);
        Log.d(DEBUG_TAG, "All data is lost.");

        onCreate(db);

    }






}















