package com.example.worktracker;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.Exclude;
import com.google.firebase.firestore.GeoPoint;

import java.util.ArrayList;
import java.util.Date;


public class Pracownik {
    private String id;
    private Date birthDate;
    private String email;
    private String firstName;
    private String kod;
    private String lastName;
    private String miejscowosc;
    private ArrayList<DocumentReference> podwladni;
    private String telefon;
    private String ulica;
    private GeoPoint miejscePracy;

    public Pracownik() {}

    public Pracownik(String firstName, String lastName,  Date birthDate,
                     String ulica, String miejscowosc, String kod, String telefon, String email,
                     ArrayList<DocumentReference> podwladni, GeoPoint miejscePracy) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.ulica = ulica;
        this.miejscowosc = miejscowosc;
        this.kod = kod;
        this.telefon = telefon;
        this.email = email;
        this.podwladni = podwladni;
        this.miejscePracy = miejscePracy;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthDate() {
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

    public ArrayList<DocumentReference> getPodwladni() {
        return podwladni;
    }

    public Pracownik setId(String id) {
        this.id = id;
        return this;
    }

    @Exclude
    public String getId() {
        return id;
    }

    public GeoPoint getMiejscePracy() {
        return miejscePracy;
    }
}
