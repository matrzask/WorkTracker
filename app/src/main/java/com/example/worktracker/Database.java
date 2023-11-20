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
import java.util.HashMap;
import java.util.Map;

/** @noinspection StatementWithEmptyBody*/
public class Database {

    private static Pracownik currentEmployee;
    public static Pracownik getEmployee(String id) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference ref = db.collection("pracownicy").document(id);
        Task<DocumentSnapshot> task = ref.get();
        while(!task.isComplete());
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
        while(!task.isComplete());
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
        while(!task.isComplete());
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
        while(!task.isComplete());
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
        return w.toObject(Tasks.class).setId(w.getId());
    }

    public static DocumentReference addTask(String idPracownika, String nazwa, String opis) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference ref = db.collection("pracownicy").document(idPracownika)
                .collection("zadania").document();
        ref.set(new Tasks(nazwa, opis));
        return ref;
    }

    public static ArrayList<Holiday> getHolidays(String id) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        CollectionReference ref = db.collection("pracownicy").document(id)
                .collection("urlopy");
        Task<QuerySnapshot> task = ref.get();
        while(!task.isComplete());
        ArrayList<Holiday> arr = new ArrayList<>();
        for(QueryDocumentSnapshot x : task.getResult()) {
            Holiday w = x.toObject(Holiday.class);
            w.setId(x.getId());
            arr.add(w);
        }
        return arr;
    }
    public static Holiday getHolidayById(String idPracownika, String idUrlopu) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference ref = db.collection("pracownicy").document(idPracownika)
                .collection("urlopy").document(idUrlopu);
        Task<DocumentSnapshot> task = ref.get();
        while(!task.isComplete());
        DocumentSnapshot w = task.getResult();
        return w.toObject(Holiday.class).setId(w.getId());
    }

    public static DocumentReference addHoliday(String idPracownika, Date dataRozpoczecia, Date dataZakonczenia) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference ref = db.collection("pracownicy").document(idPracownika)
                .collection("urlopy").document();
        ref.set(new Holiday(dataRozpoczecia, dataZakonczenia));
        return ref;
    }

    //If login suceeds returns true and sets current employee to the logged in user
    public static boolean login(String username, String password) {
        if(username.isEmpty()) return false;
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference ref = db.collection("users").document(username);
        Task<DocumentSnapshot> task = ref.get();
        while(!task.isComplete());
        if(!task.getResult().exists()) return false;
        if(!task.getResult().get("password", String.class).equals(password)) return false;
        currentEmployee = getEmployee(task.getResult().get("idPracownika", String.class));
        return true;
    }
    public static Pracownik getCurrentEmployee() {
        return currentEmployee;
    }

    public static DocumentReference addUser(String username, String password, String idPracownika) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference ref = db.collection("users").document(username);
        Map<String, String> user = new HashMap<>();
        user.put("password", password);
        user.put("idPracownika", idPracownika);
        ref.set(user);
        return ref;
    }
}
