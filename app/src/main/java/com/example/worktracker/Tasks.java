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
    public Tasks(String nazwa, String opis) {
        this.nazwa = nazwa;
        this.status = "Do zrobienia";
        this.opis = opis;
    }
    public Tasks(String nazwa, String opis, String status) {
        this.nazwa = nazwa;
        this.status = status;
        this.opis = opis;
    }
    @Exclude
    public String getId() {
        return id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public String getStatus() {
        return status;
    }

    public String getOpis() {
        return opis;
    }

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
