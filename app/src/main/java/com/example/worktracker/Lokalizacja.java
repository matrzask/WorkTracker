package com.example.worktracker;

import static androidx.core.app.ActivityCompat.requestPermissions;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.location.Location;

import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.GeoPoint;

/**
 * Klasa zajmuje sie obsluga lokalizacji pracownika.*/
public class Lokalizacja {

    /**
     * Metoda sluzy do uzyskania pozwolenia na dostep do lokalizacji od systemu Android.
     * @param a instancja wbudowanej klasy Activity, obecna aktywnosc uzytkownika.
     * */
    static public void RequestPerm(Activity a) {
        if (ActivityCompat.checkSelfPermission(a, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(a, new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION, android.Manifest.permission.ACCESS_FINE_LOCATION}, 123);
        }
    }

    /**
     * Metoda uzyskyje obecna lokalizacje uzytkownika.
     * @param a instancja wbudowanej klasy Activity, obecna aktywnosc uzytkownika.
     * @return lokalizacja, instancja wbudowanej klasy Location.
     * */
    static public Location GetLocation(Activity a) {
        FusedLocationProviderClient fusedLocationClient = LocationServices.getFusedLocationProviderClient(a);
        if (ActivityCompat.checkSelfPermission(a, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(a, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            RequestPerm(a);
            return null;
        }
        Task<Location> loc = fusedLocationClient.getLastLocation();
        while(!loc.isComplete()) {}
        return loc.getResult();
    }

    /**
     * Metoda sprawdza czy uzytkownik jest w obrebie pewnej lokalizacji, domyslnie firmy.
     * @param a instancja wbudowanej klasy Activity, obecna aktywnosc uzytkownika.
     * @param maxDist maksymalny dystans uzytkownika od ustalonej lokalizacji
     * @return Czy uzytkownik jest w obrebie lokalizacji, true  lub false.
     * */
    static public boolean IsEmployeeAtWork(Activity a, float maxDist) {
        Pracownik p = Database.getCurrentEmployee();
        if(p == null) return false;
        GeoPoint praca = p.getMiejscePracy();
        if(praca == null) return false;
        Location l = GetLocation(a);
        if(l == null) return false;
        GeoPoint employee = new GeoPoint(l.getLatitude(), l.getLongitude());
        return praca.compareTo(employee) <= maxDist;
    }
}
