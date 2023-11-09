package com.example.worktracker;

import com.google.firebase.Firebase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.lang.ref.Reference;
import java.time.LocalDate;
import java.util.ArrayList;


public class Pracownik {
    private LocalDate data_urodzenia;
    private String email;
    private String imie;
    private String kod;
    private String nazwisko;
    private Reference<Menager> manager;
    private miejsce_lokalizacji
    private String miejscowosc;
    private ArrayList<Pracownik> podwładni;
    private String telefon;
    private String ulica;

}
