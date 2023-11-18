package com.example.worktracker;

import java.util.ArrayList;
import java.util.Date;
import com.google.firebase.Timestamp;


public class Pracownik {
    private Timestamp birthDate;
    private String email;
    private String firstName;
    private String kod;
    private String lastName;
    private String miejscowosc;
    private ArrayList<Pracownik> podwladni;
    private String telefon;
    private String ulica;

    public Pracownik() {}

    public Pracownik(String firstName, String lastName,  Timestamp birthDate,
                     String ulica, String miejscowosc, String kod, String telefon, String email,
                     ArrayList<Pracownik> podwladni) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.ulica = ulica;
        this.miejscowosc = miejscowosc;
        this.kod = kod;
        this.telefon = telefon;
        this.email = email;
        this.podwladni = podwladni;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Timestamp getBirthDate() {
        return birthDate;
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
