package com.example.milek.projektztp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Milek on 2017-01-16.
 */

public class IteratorProduktow implements  Iterator<Produkt> {

    private List<Produkt> Lista = new ArrayList<>();
    private Produkt pom = null;
    private int pozycja = 0;
    private Calendar calendar;
    private int day;
    private String opis;


    public IteratorProduktow(List<Produkt> items) {
        this.Lista = items;
        calendar = Calendar.getInstance();
        day = calendar.get(Calendar.DAY_OF_WEEK);

    }

    @Override
    public Produkt next() {
        Produkt item = Lista.get(pozycja);
        opis = item.getOpis();

        switch (day) {

            case Calendar.MONDAY:

                if (item.getOpis().toLowerCase().contains("czarn") == false) {

                    while (!item.getOpis().toLowerCase().contains("czarn")) {
                        if (pozycja >= Lista.size()) break;
                        else if (pozycja == Lista.size() - 1)
                        {
                            item = new Produkt("brak", 0, "brak");
                            break;
                        }
                        else {
                            pozycja++;
                            item = Lista.get(pozycja);
                        }
                    }
                }

                break;
            case Calendar.TUESDAY:

                if (item.getOpis().toLowerCase().contains("zielo") == false) {

                    while (!item.getOpis().toLowerCase().contains("zielo")) {
                        if (pozycja >= Lista.size()) break;
                        else if (pozycja == Lista.size() - 1)
                            {
                            item = new Produkt("brak", 0, "brak");
                            break;
                            }
                        else {
                            pozycja++;
                            item = Lista.get(pozycja);
                            }
                    }
                }
                pozycja++;
                break;

                default: pozycja++;
                break;
        }
        return item;
    }

    @Override
    public boolean hasNext() {

        if (pozycja >= Lista.size() || Lista.get(pozycja) == null) return false;
        else return true;
    }
}