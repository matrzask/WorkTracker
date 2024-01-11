package com.example.worktracker;

import com.google.firebase.firestore.Exclude;

import java.util.Date;


/**
 * Klasa reprezentujaca godziny pracy pracownika w danym dniu. Przechowuje dane potrzebne do rozpoznania
 * pracownika ktory wykonal prace, a takze dodatkowe informacje takie jak
 * czas rozpoczecia i zakonczenia pracy, ilosc przepracowanych godzin i date danego dnia.
 * Zawiera wszystkie potrzebne gettery i settery pozwalajace pobierac wartosci zmiennych i je modyfikowac.
 */
public class WorkingHours {
    private String id;
    private Date data;
    private float godziny;
    private Date czasRozpoczecia;
    private Date czasZakonczenia;

    public WorkingHours() {}
    public WorkingHours(Date data, Date czasRozpoczecia, Date czasZakonczenia) {
        this.data = data;
        this.czasZakonczenia = czasZakonczenia;
        this.czasRozpoczecia = czasRozpoczecia;
        this.godziny = (czasZakonczenia.getTime() - czasRozpoczecia.getTime())/3600000f;
    }

    @Exclude
    public String getId() {
        return id;
    }
    public Date getData() {
        return data;
    }

    public float getGodziny() {
        return godziny;
    }

    public WorkingHours setId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Sprawdza czy pracownik przepracowal wymagane minimum 8h
     * @return true jesli pracowal wiecej lub rowno 8h, false jesli pracowal mniej
     */
    public boolean czyOsiemGodzin() {
        return godziny >= 8;
    }

    public Date getCzasRozpoczecia() {
        return czasRozpoczecia;
    }

    public Date getCzasZakonczenia() {
        return czasZakonczenia;
    }
}
