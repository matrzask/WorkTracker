package com.example.worktracker;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.firebase.firestore.FirebaseFirestore;

import java.lang.ref.Reference;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

@RequiresApi(api = Build.VERSION_CODES.O)
public class Database {

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    public void main(String[] arg) {
        Pracownik p2 = new Pracownik("Anna", "Nowak", LocalDate.of(1998, 11, 10),
                "Mickiewicza 55", "Warszawa", "15-456", "890890890","anowak@poczta.pl", new ArrayList<>(0));
        db.collection("pracownicy").document("2").set(p2);
    }

}
