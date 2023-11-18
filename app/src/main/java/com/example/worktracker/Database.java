package com.example.worktracker;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Date;

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

    public static ArrayList<WorkingHours> getWorkingHours(String id) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        CollectionReference ref = db.collection("pracownicy").document(id)
                .collection("czas_pracy");
        Task<QuerySnapshot> task = ref.get();
        while(!task.isComplete()) {}
        ArrayList<WorkingHours> arr = new ArrayList<>();
        for(QueryDocumentSnapshot x : task.getResult()) {
            WorkingHours w = x.toObject(WorkingHours.class);
            w.setId(x.getId());
            arr.add(w);
        }
        return arr;
    }
    public static WorkingHours getWorkingHoursById(String idPracownika, String idDnia) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference ref = db.collection("pracownicy").document(idPracownika)
                .collection("czas_pracy").document(idDnia);
        Task<DocumentSnapshot> task = ref.get();
        while(!task.isComplete()) {}
        DocumentSnapshot w = task.getResult();
        return w.toObject(WorkingHours.class);
    }

    public static DocumentReference addWorkingHours(Date data, String idPracownika, Date czasRozpoczecia, Date czasZakonczenia) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference ref = db.collection("pracownicy").document(idPracownika)
                .collection("czas_pracy").document();
        ref.set(new WorkingHours(data, czasRozpoczecia, czasZakonczenia));
        return ref;
    }

    public static ArrayList<Tasks> getTasks(String id) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        CollectionReference ref = db.collection("pracownicy").document(id)
                .collection("zadania");
        Task<QuerySnapshot> task = ref.get();
        while(!task.isComplete()) {}
        ArrayList<Tasks> arr = new ArrayList<>();
        for(QueryDocumentSnapshot x : task.getResult()) {
            Tasks w = x.toObject(Tasks.class);
            w.setId(x.getId());
            arr.add(w);
        }
        return arr;
    }
    public static Tasks getTaskById(String idPracownika, String idZadania) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference ref = db.collection("pracownicy").document(idPracownika)
                .collection("zadania").document(idZadania);
        Task<DocumentSnapshot> task = ref.get();
        while(!task.isComplete()) {}
        DocumentSnapshot w = task.getResult();
        return w.toObject(Tasks.class);
    }

    public static DocumentReference addTask(String idPracownika, String nazwa, String opis) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference ref = db.collection("pracownicy").document(idPracownika)
                .collection("zadania").document();
        ref.set(new Tasks(nazwa, opis));
        return ref;
    }
}
