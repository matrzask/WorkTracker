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
    private Reference<Menager> manager;
    private
    private String miejscowosc;
    private ArrayList<Pracownik> podwładni;
    private String telefon;
    private String ulica;

}
