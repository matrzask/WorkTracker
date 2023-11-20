package com.example.worktracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.Timestamp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Registration extends AppCompatActivity {
    private Button buttonBackReg;
    /*private Button buttonReg;

    private TextView username = (TextView) findViewById(R.id.registerUsername);
    private TextView password = (TextView) findViewById(R.id.registerPassword);
    private TextView imie = (TextView) findViewById(R.id.registerImie);
    private TextView nazwisko = (TextView) findViewById(R.id.registerNazwisko);
    private TextView ulica = (TextView) findViewById(R.id.registerUlica);
    private TextView miejscowosc = (TextView) findViewById(R.id.registerMiejscowosc);
    private TextView kod = (TextView) findViewById(R.id.registerKod);
    private TextView telefon = (TextView) findViewById(R.id.registerTelefon);
    private TextView email = (TextView) findViewById(R.id.registerEmail);
    Pracownik registrator = new Pracownik(imie.getText().toString(), nazwisko.getText().toString(), new Date(),
            ulica.getText().toString(), miejscowosc.getText().toString(), kod.getText().toString(),
            telefon.getText().toString(), email.getText().toString(), new ArrayList<>());*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        buttonBackReg = (Button) findViewById(R.id.buttonBackReg);
        //buttonReg = (Button) findViewById(R.id.registerButton2);

        buttonBackReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLogin();
            }
        });

      /*  buttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer number = new Random().nextInt(1000000);
                String id = number.toString();
                Database.addUser(username.getText().toString(), password.getText().toString(), id);
                Database.addEmployee(registrator);
                openLogin();
            }
        });*/
    }

    public void openLogin() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}