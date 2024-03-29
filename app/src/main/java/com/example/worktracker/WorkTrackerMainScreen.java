package com.example.worktracker;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.firebase.Firebase;
import com.google.firebase.Timestamp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.GeoPoint;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Klasa reprezentuje ekran, ktory widzi pracownik po zalogowaniu.
 * Zawiera przyciski: 'WYLOGUJ', 'ZADANIA' i 'STATYSTYKI' oraz
 * informacje o przepracowanych danego dnia godzinach.
 * */
public class WorkTrackerMainScreen extends AppCompatActivity {
    private Button logout;
    private Button button_zad;
    private Button button_stat;
    private TextView name;
    private TextView timerText;
    private Button stopStartButton;

    boolean timerstarted = false;
    Timer timer;
    TimerTask timerTask;
    Double time = 0.0;


    Thread czas = new Thread(new Runnable() {
        @Override
        public void run() {
            timer = new Timer();
            startTimer();
        }
    });

    /**
     * Tworzy ekran glowny pracownika.
     * @param savedInstanceState
     */
    @SuppressLint("MissingInflatedId")
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_tracker_main_screen);

        button_zad = (Button) findViewById(R.id.button_zad);
        button_zad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openZadania();
            }
        });

        button_stat = (Button) findViewById(R.id.button_stat);
        button_stat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openStatystyki();
            }
        });

        logout = (Button) findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLogin();
            }
        });

        name = (TextView) findViewById(R.id.textView);
        String s = "Witaj " + Database.getCurrentEmployee().getFirstName()+ " " + Database.getCurrentEmployee().getLastName();
        name.setText(s);

        timerText = (TextView) findViewById(R.id.godziny);

        stopStartButton = (Button) findViewById(R.id.stopstart);
        timer = new Timer();
    }


    /**
     * Otwiera menu zadania pracownika.
     */
    public void openZadania() {
        Intent intent = new Intent(this, Zadania.class);
        startActivity(intent);
    }

    /**
     * Otwiera menu statystyk pracownika.
     */
    public void openStatystyki() {
        Intent intent = new Intent(this, Statystyki.class);
        startActivity(intent);
    }

    /**
     * Wylogowywuje pracownika.
     */
    public void openLogin() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    public void startstopTapped(View view) {
        if(Lokalizacja.IsEmployeeAtWork(WorkTrackerMainScreen.this, 0.01F)) {
            if(timerstarted == false) {
                timerstarted = true;
                stopStartButton.setText("STOP");
                stopStartButton.setTextColor(ContextCompat.getColor(this, R.color.red));
                startTimer();
            }
            else {
                timerstarted = false;
                stopStartButton.setText("START");
                stopStartButton.setTextColor(ContextCompat.getColor(this, R.color.green));
                timerTask.cancel();
            }
        }
        else {
            Toast.makeText(WorkTrackerMainScreen.this, "Lokalizacja nie zgadza się! Skontaktuj się z przełożonym.", Toast.LENGTH_SHORT).show();
        }


    }

    public void startTimer() {
        timerTask = new TimerTask() {
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        time++;
                        timerText.setText(getTimerText());
                    }
                });
            }

        };
        timer.scheduleAtFixedRate(timerTask, 0, 1000);
    }

    public String getTimerText() {
    int rounded = (int) Math.round(time);
    int seconds = ((rounded % 86400) % 3600) % 60;
    int minutes = ((rounded % 86400) % 3600) / 60;
    int hours = (rounded % 86400) / 3600;
    return formatTime(seconds, minutes, hours);
    }

    public String formatTime(int seconds, int minutes, int hours) {
        return String.format("%02d", hours) + ":" + String.format("%02d", minutes) + ":" + String.format("%02d", seconds);
    }

}
