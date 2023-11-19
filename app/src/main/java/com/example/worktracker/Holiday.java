package com.example.worktracker;

import com.google.firebase.firestore.Exclude;

import java.util.Date;

public class Holiday {
    private String id;
    private int liczbaDni;
    private Date dataRozpoczecia;
    private Date dataZakonczenia;
    public Holiday() {}
    public Holiday(Date czasRozpoczecia, Date czasZakonczenia) {
        this.dataRozpoczecia = czasRozpoczecia;
        this.dataZakonczenia = czasZakonczenia;
        this.liczbaDni = (int) ((czasZakonczenia.getTime() - czasRozpoczecia.getTime())/86400000);
    }

    @Exclude
    public String getId() {
        return id;
    }

    public float getLiczbaDni() {
        return liczbaDni;
    }

    public Holiday setId(String id) {
        this.id = id;
        return this;
    }

    public Date getDataRozpoczecia() {
        return dataRozpoczecia;
    }

    public Date getDataZakonczenia() {
        return dataZakonczenia;
    }
}
