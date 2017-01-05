package com.example.milek.projektztp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Milek on 2017-01-04.
 */

public class ListaAdapter  extends ArrayAdapter<Produkt> {

    List<Produkt> mylist;
    private final Context context;

    public ListaAdapter(Context _context, List<Produkt> _mylist) {
        super(_context, R.layout.lista_produkty, _mylist);

        this.mylist = _mylist;
        this.context = _context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        convertView = new LinearLayout(getContext());
        String inflater = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater vi = (LayoutInflater)getContext().getSystemService(inflater);
        convertView = vi.inflate(R.layout.lista_produkty, parent, false);



        // Product object
        Produkt product = getItem(position);
        //
        TextView txtTitle = (TextView) convertView.findViewById(R.id.nazwa);
        txtTitle.setText(product.nazwa);

        TextView txtPrice = (TextView) convertView.findViewById(R.id.cena);
        txtPrice.setText(Float.toString(product.cena) + " zł");

        TextView txtDesc = (TextView) convertView.findViewById(R.id.opis);
        txtDesc.setText(product.opis);

        // show image
        //ImageView img = (ImageView)convertView.findViewById(R.id.image);

        // download image
        //img.setImageResource(product.img_url);

        return convertView;
    }



}