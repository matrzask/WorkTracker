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

    //Adds employee to database and returns a reference to the new document (use ref.getID to get employee id from it)
    public static DocumentReference addEmployee(Pracownik p) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference ref = db.collection("pracownicy").document();
        ref.set(p);
        return ref;
    }

}
