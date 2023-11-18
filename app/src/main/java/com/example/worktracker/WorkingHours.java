package com.example.worktracker;

import com.google.firebase.firestore.Exclude;

import java.util.Date;

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
        this. czasRozpoczecia = czasRozpoczecia;
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

    public void setId(String id) {
        this.id = id;
    }

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
