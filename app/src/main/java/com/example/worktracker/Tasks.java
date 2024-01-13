package com.example.worktracker;

import com.google.firebase.firestore.Exclude;

/**
 * Klasa reprezentuje zadanie danego pracownika. Przechowuje dane o tym zadaniu. Zawiera gettery i
 * settery potrzebne do pobierania i modyfikowania zmiennych
 */
public class Tasks {
    private String id;
    private String nazwa;
    private String status;
    private String opis;

    public Tasks() {}

    /**
     * Konstruktor taskow, uzywany glownie do dodawania taskow.
     * @param nazwa
     * @param opis
     */
    public Tasks(String nazwa, String opis) {
        this.nazwa = nazwa;
        this.status = "Do zrobienia";
        this.opis = opis;
    }

    /**
     * Konstruktor taskow, z mozliwoscia wyboru statusu zadania.
     * @param nazwa
     * @param opis
     * @param status
     */
    public Tasks(String nazwa, String opis, String status) {
        this.nazwa = nazwa;
        this.status = status;
        this.opis = opis;
    }

    /**
     * zwraca id zadania.
     * @return string
     */
    @Exclude
    public String getId() {
        return id;
    }

    /**
     * zwraca nazwę zadania.
     * @return string
     */
    public String getNazwa() {
        return nazwa;
    }

    /**
     * zwraca status zadania.
     * @return string
     */
    public String getStatus() {
        return status;
    }

    /**
     * zwraca opis zadania.
     * @return string
     */
    public String getOpis() {
        return opis;
    }

    /**
     * Ustawia id zadania.
     * @param id
     * @return Tasks
     */
    public Tasks setId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Pozwala na zmiane statusu danego zadania
     * @param status status na ktory chcemy zmienic aktualny status zadania
     * @return zadanie ktoremu wlasnie zmienilismy status
     */
    public Tasks changeStatus(String status) {
        if (status.equals("Do zrobienia") || status.equals("W trakcie") || status.equals("Wykonane"))
            this.status = status;
        else
            throw new RuntimeException("Niepoprawny status");
        return this;
    }
}
