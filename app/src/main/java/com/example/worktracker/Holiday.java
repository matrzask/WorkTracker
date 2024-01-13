package com.example.worktracker;

import com.google.firebase.firestore.Exclude;

import java.util.Date;


/**
 * Klasa reprezentuje urlop danego pracownika. Przechowuje informacje o danym urlopie. Zawiera gettery i
 * settery pozwalajace na pobieranie i modyfikowanie zmiennych.
 */
public class Holiday {
    private String id;
    private int liczbaDni;
    private Date dataRozpoczecia;
    private Date dataZakonczenia;
    public Holiday() {}

    /**
     * Konstruktor urlopów.
     * @param czasRozpoczecia
     * @param czasZakonczenia
     */
    public Holiday(Date czasRozpoczecia, Date czasZakonczenia) {
        this.dataRozpoczecia = czasRozpoczecia;
        this.dataZakonczenia = czasZakonczenia;
        this.liczbaDni = (int) ((czasZakonczenia.getTime() - czasRozpoczecia.getTime())/86400000);
    }

    /**
     * zwraca id urlopu
     * @return string
     */
    @Exclude
    public String getId() {
        return id;
    }

    /**
     * zwraca liczbę dni
     * @return int
     */
    public int getLiczbaDni() {
        return liczbaDni;
    }

    /**
     * ustawia id urlopu
     * @param id
     * @return Holiday
     */
    public Holiday setId(String id) {
        this.id = id;
        return this;
    }

    /**
     * zwraca date rozpoczecia urlopu.
     * @return date
     */
    public Date getDataRozpoczecia() {
        return dataRozpoczecia;
    }


    /**
     * zwraca date zakonczenia urlopu.
     * @return date
     */
    public Date getDataZakonczenia() {
        return dataZakonczenia;
    }
}
