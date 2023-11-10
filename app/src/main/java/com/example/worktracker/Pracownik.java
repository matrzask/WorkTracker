package com.example.worktracker;

import com.google.firebase.Firebase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.lang.ref.Reference;
import java.time.LocalDate;
import java.util.ArrayList;


public class Pracownik {
    private LocalDate birth_date;
    private String email;
    private String first_name;
    private String kod;
    private String last_name;
    private String miejscowosc;
    private ArrayList<Pracownik> podwladni;
    private String telefon;
    private String ulica;

    public Pracownik() {}

    public Pracownik(String first_name, String last_name, LocalDate birth_date,
                     String ulica, String miejscowosc, String kod, String telefon, String email,
                     ArrayList<Pracownik> podwladni) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.birth_date = birth_date;
        this.ulica = ulica;
        this.miejscowosc = miejscowosc;
        this.kod = kod;
        this.telefon = telefon;
        this.email = email;
        this.podwladni = podwladni;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public LocalDate getBirth_date() {
        return birth_date;
    }

    public String getUlica() {
        return ulica;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public String getKod() {
        return kod;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Pracownik> getPodwladni() {
        return podwladni;
    }
}
