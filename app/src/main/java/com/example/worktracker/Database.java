package com.example.worktracker;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class Database {

    public static Pracownik getEmployee(String id) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference ref = db.collection("pracownicy").document(id);
        ref.get();
        return null;
    }

    public static void addEmployee(Pracownik p) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("pracownicy").add(p);
    }

}
