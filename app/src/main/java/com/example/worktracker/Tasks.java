package com.example.worktracker;

import com.google.firebase.firestore.Exclude;

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

    public void setId(String id) {
        this.id = id;
    }

    public void changeStatus(String status) {
        if (status.equals("Do zrobienia") || status.equals("W trakcie") || status.equals("Wykonane"))
            this.status = status;
        else
            throw new RuntimeException("Niepoprawny status");
    }
}
