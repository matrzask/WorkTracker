package com.example.worktracker;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.Exclude;
import com.google.firebase.firestore.GeoPoint;

import java.util.ArrayList;
import java.util.Date;

/**
 * Klasa reprezentujaca pracownika. Przechowuje dane pracownika. Zawiera settery i gettery potrzebne
 * do pobierania danych pracownika i przypisywania zmiennym konkretnych wartosci.
 */
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

    /**
     * Konstruktor pracownika z parametrami.
     * @param firstName
     * @param lastName
     * @param birthDate
     * @param ulica
     * @param miejscowosc
     * @param kod
     * @param telefon
     * @param email
     * @param podwladni
     * @param miejscePracy
     */
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


    /**
     * zwraca imie pracownika
     * @return string
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * zwraca nazwisko pracownika
     * @return string
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * zwraca datę urodzenia pracownika
     * @return date
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * zwraca ulicę i numer pracownika
     * @return string
     */
    public String getUlica() {
        return ulica;
    }

    /**
     * zwraca miejscowosc zamieszkania
     * @return string
     */
    public String getMiejscowosc() {
        return miejscowosc;
    }

    /**
     * zwraca kod pocztowy
     * @return string
     */
    public String getKod() {
        return kod;
    }

    /**
     * zwraca telefon
     * @return string
     */
    public String getTelefon() {
        return telefon;
    }

    /**
     * zwraca email
     * @return string
     */
    public String getEmail() {
        return email;
    }

    /**
     * zwraca liste podwladnych w przypadku managera, w przypadku zwyklego pracownika lista jest pusta.
     * @return string
     */
    public ArrayList<DocumentReference> getPodwladni() {
        return podwladni;
    }

    /**
     * Ustawia id pracownika
     * @param id
     * @return Pracownik
     */
    public Pracownik setId(String id) {
        this.id = id;
        return this;
    }

    /**
     * zwraca id pracownika
     * @return string
     */
    @Exclude
    public String getId() {
        return id;
    }

    /**
     * zwrca lokalizacje, miejsce pracy
     * @return GeoPoint
     */
    public GeoPoint getMiejscePracy() {
        return miejscePracy;
    }
}
