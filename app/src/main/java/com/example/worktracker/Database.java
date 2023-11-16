package com.example.worktracker;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Database {

    public static Pracownik getEmployee(String id) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference ref = db.collection("pracownicy").document(id);
        Task<DocumentSnapshot> task = ref.get();
        while(!task.isComplete()) {}
        DocumentSnapshot p = task.getResult();
        return p.toObject(Pracownik.class);
    }

    //Adds employee to database and returns a reference to the new document (use ref.getID to get employee id from it)
    public static DocumentReference addEmployee(Pracownik p) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference ref = db.collection("pracownicy").document();
        ref.set(p);
        return ref;
    }

}
