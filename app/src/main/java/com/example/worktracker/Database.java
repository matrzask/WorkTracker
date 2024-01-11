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

/**
 * Klasa sluzaca do kontaktu z baza danych, pelniaca role backendu
 */
public class Database {
    /**
     * pracownik dla ktorego chcemy pobrac lub zaktualizowac dane
     */
    private static Pracownik currentEmployee;

    /**
     * Przelozony pracownika dla ktorego chcemy pobrac lub zaktualizowac dane
     */
    private static Pracownik currentEmployer;

    /**
     * Zwraca pracownika o podanym id
     * @param id Id danego pracownika
     * @return Obiekt klasy Pracownik
     */
    public static Pracownik getEmployee(String id) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference ref = db.collection("pracownicy").document(id);
        Task<DocumentSnapshot> task = ref.get();
        while(!task.isComplete());
        DocumentSnapshot p = task.getResult();
        return p.toObject(Pracownik.class).setId(id);
    }

    /**
     * Zwraca pracownika na podstawie referencji
     * @param ref referencja dokumentu
     * @return Obiekt klasy pracownik
     */
    public static Pracownik getEmployee(DocumentReference ref) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Task<DocumentSnapshot> task = ref.get();
        while(!task.isComplete());
        DocumentSnapshot p = task.getResult();
        return p.toObject(Pracownik.class).setId(ref.getId());
    }

    //Adds employee to database and returns a reference to the new document (use ref.getID to get employee id from it)

    /**
     * Dodaje pracownika do bazy danych
     * @param p pracownik ktorego chcemy dodac, jest obiektem klasy Pracownik
     * @return Zwraca referencje do dodanego pracownika
     */
    public static DocumentReference addEmployee(Pracownik p) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference ref = db.collection("pracownicy").document();
        ref.set(p);
        return ref;
    }

    /**
     * Sluzy do uzyskania informacji na temat czasu przepracowanego przez pracownika
     * @param id Id pracownika dla ktorego chcemy wyszukac godziny jego pracy
     * @return lista zawierajaca obiekty klasy WorkingHours
     */
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

    /**
     * Podaje godziny przepracowane przez pracownika w danym dniu
     * @param idPracownika Id pracownika dla ktorego chcemy wyszukac szczegoly jego przepracowanego czasu
     * @param idDnia Id dnia dla ktorego chcemy wyszukac szczegoly godzin pracy danego pracownika
     * @return Obiekt klasy WorkingHours zawierajacy informacje o czasie pracy pracownika w dany dzien
     */
    public static WorkingHours getWorkingHoursById(String idPracownika, String idDnia) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference ref = db.collection("pracownicy").document(idPracownika)
                .collection("czas_pracy").document(idDnia);
        Task<DocumentSnapshot> task = ref.get();
        while(!task.isComplete());
        DocumentSnapshot w = task.getResult();
        return w.toObject(WorkingHours.class);
    }

    /**
     * Dodaje do bazy danych przepracowany przez pracownika dzień
     * @param data data dnia pracy
     * @param idPracownika id pracownika ktory wykonal prace
     * @param czasRozpoczecia czas rozpoczecia pracy przez pracownika
     * @param czasZakonczenia czas zakonczenia pracy przez pracownika
     * @return Referencja do dodanych przez nas WorkingHours
     */
    public static DocumentReference addWorkingHours(Date data, String idPracownika, Date czasRozpoczecia, Date czasZakonczenia) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference ref = db.collection("pracownicy").document(idPracownika)
                .collection("czas_pracy").document();
        ref.set(new WorkingHours(data, czasRozpoczecia, czasZakonczenia));
        return ref;
    }

    /**
     * Zwraca zadania danego pracownika
     * @param id id pracownika dla ktorego chcemy otrzymac zadania
     * @return Lista zadan dla danego pracownika
     */
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

    /**
     * Zwraca zadanie danego pracownika na podstawie id zadania
     * @param idPracownika id pracownika ktorego zadanie chcemy zwrocic
     * @param idZadania id zadania ktore chcemy zwrocic
     * @return Obiekt klasy Tasks bedacy zadaniem danego pracownika
     */
    public static Tasks getTaskById(String idPracownika, String idZadania) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference ref = db.collection("pracownicy").document(idPracownika)
                .collection("zadania").document(idZadania);
        Task<DocumentSnapshot> task = ref.get();
        while(!task.isComplete()) {}
        DocumentSnapshot w = task.getResult();
        return w.toObject(Tasks.class).setId(w.getId());
    }

    /**
     * Dodaje zadanie dla danego pracownika do bazy danych
     * @param idPracownika id pracownika ktoremu chcemy przypisac zadanie
     * @param nazwa nazwa zadania
     * @param opis opis naszego zadania
     * @return referencja do dodanego przez nas zadania
     */
    public static DocumentReference addTask(String idPracownika, String nazwa, String opis) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference ref = db.collection("pracownicy").document(idPracownika)
                .collection("zadania").document();
        ref.set(new Tasks(nazwa, opis));
        return ref;
    }

    /**
     * Zwraca urlopy pracownika o podanym id
     * @param id id pracownika dla ktorego chcemy sprawdzic jego urlopy
     * @return lista urlopow pracownika
     */
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

    /**
     * Zwraca konkretny urlop pracownika o podanym id
     * @param idPracownika id pracownika do ktorego nalezy urlop
     * @param idUrlopu id urlopu ktory chcemy zwrocic
     * @return Obiekt klasy Holiday, bedacy urlopem pracownika
     */
    public static Holiday getHolidayById(String idPracownika, String idUrlopu) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference ref = db.collection("pracownicy").document(idPracownika)
                .collection("urlopy").document(idUrlopu);
        Task<DocumentSnapshot> task = ref.get();
        while(!task.isComplete());
        DocumentSnapshot w = task.getResult();
        return w.toObject(Holiday.class).setId(w.getId());
    }

    /**
     * Dodaje urlop danego pracownika do bazy
     * @param idPracownika id pracownika ktoremu chcemy dodac urlop
     * @param dataRozpoczecia data rozpoczecia urlopu
     * @param dataZakonczenia data zakonczenia urlopu
     * @return Referencje do dodanego przez nas urlopu
     */
    public static DocumentReference addHoliday(String idPracownika, Date dataRozpoczecia, Date dataZakonczenia) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference ref = db.collection("pracownicy").document(idPracownika)
                .collection("urlopy").document();
        ref.set(new Holiday(dataRozpoczecia, dataZakonczenia));
        return ref;
    }

    //If login suceeds returns true and sets current employee to the logged in user

    /**
     * Odpowiada za logowanie uzytkownika, jesli logowanie sie powiodlo, ustawia currentEmployee jako zalogowanego
     * @param username nazwa uzytkownika chcacego sie zalogowac
     * @param password haslo podane przez uzytkownika
     * @return jesli zalogowanie sie udalo, zwraca true
     */
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

    /**
     * Zwraca aktualnego pracownika
     * @return aktualny pracownik
     */
    public static Pracownik getCurrentEmployee() {
        return currentEmployee;
    }

    /**
     * Ustawia zmienna aktualnego pracownika i jego pracodawce
     * @param p aktualny pracownik
     * @param employer pracodawca aktualnego pracownika
     */
    public static void setCurrentEmployee(Pracownik p, Pracownik employer) {
        currentEmployee = p;
        currentEmployer = employer;
    }

    /**
     * Zwraca aktualnego pracodawce
     * @return aktualny pracodawca
     */
    public static  Pracownik getCurrentEmployer() { return currentEmployer; }

    /**
     * Dodaje użytkownika do bazy danych
     * @param username nazwa pracownika ktorego chcemy dodac
     * @param password haslo pracownika ktorego chcemy dodac
     * @param idPracownika id pracownika ktorego chcemy dodac
     * @return referencja do dodanego przez nas uzytkownika
     */
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
