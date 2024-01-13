package com.example.worktracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.GeoPoint;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 * Klasa, ktora reprezentuje ekran z rejestracja pracownika. Wyswietlone są pola do uzupelnienia danych, nazwy uzytkownika i hasla.
 * Zawiera dwa przyciski: 'zatwierdz' i 'powrot'. Nacisniecie przycisku 'zatwierdz' powoduje dodanie pracownika do bazy danych, wraz z jego danymi, username i password.
 */
public class Registration extends AppCompatActivity {
    private Button buttonBackReg;
    private Button buttonReg;

    /**
     * Tworzy ekran z rejestracja.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        buttonBackReg = (Button) findViewById(R.id.buttonBackReg);
        buttonReg = (Button) findViewById(R.id.registerButton2);

        buttonBackReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLogin();
            }
        });

        TextView username = (TextView) findViewById(R.id.registerUsername);
        TextView password = (TextView) findViewById(R.id.registerPassword);
        TextView imie = (TextView) findViewById(R.id.registerImie);
        TextView nazwisko = (TextView) findViewById(R.id.registerNazwisko);
        TextView ulica = (TextView) findViewById(R.id.registerUlica);
        TextView miejscowosc = (TextView) findViewById(R.id.registerMiejscowosc);
        TextView kod = (TextView) findViewById(R.id.registerKod);
        TextView telefon = (TextView) findViewById(R.id.registerTelefon);
        TextView email = (TextView) findViewById(R.id.registerEmail);

        // dodaje użytkownika/pracownika do bazy danych
      buttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer number = new Random().nextInt(10000000);
                String id = number.toString();
                Database.addUser(username.getText().toString(), password.getText().toString(), id);
                Database.addEmployee(new Pracownik(imie.getText().toString(), nazwisko.getText().toString(), new Date(),
                        ulica.getText().toString(), miejscowosc.getText().toString(), kod.getText().toString(),
                        telefon.getText().toString(), email.getText().toString(), new ArrayList<>(), new GeoPoint(0,0)));
                openLogin();
            }
        });
    }

    /**
     * Wraca do ekranu z logowaniem.
     */
    public void openLogin() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}