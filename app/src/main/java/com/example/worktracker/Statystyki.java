package com.example.worktracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Klasa reprezentuje ekran dajacy dostep do roznych statystyk danemu pracownikowi.
 * Zawiera przyciski: 'GODZINY PRACY', 'URLOPY', 'ARCHIWUM ZADAN',
 * ktore wyswietlaja odpowiednie statystyki, oraz 'POWROT'.
 * */
public class Statystyki extends AppCompatActivity {
    private Button button_back2;
    private Button urlopy;
    private Button buttonGod;

    /**
     * Tworzy ekran do wyboru statystyk.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statystyki);

        button_back2 = (Button) findViewById(R.id.button_back2);
        button_back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainMenu();
            }
        });

        urlopy = (Button) findViewById(R.id.button_ur);
        urlopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openUrlopy();
            }
        });

        buttonGod = (Button) findViewById(R.id.button_god);
        buttonGod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGodziny();
            }
        });

        Button buttonArz = (Button) findViewById(R.id.button_arz);
        buttonArz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openArchiwum();
            }
        });
    }


    /**
     * Wraca do ekranu glownego pracownika.
     */
    public void openMainMenu() {
        Intent intent = new Intent(this, WorkTrackerMainScreen.class);
        startActivity(intent);
    }

    /**
     * Otwiera ekran z informacjami na temat urlopow pracownika.
     */
    public void openUrlopy() {
        Intent intent = new Intent(this, Urlopy.class);
        startActivity(intent);
    }

    /**
     * Otwiera ekran z informacjami na temat godzin pracy pracownika.
     */
    public void openGodziny() {
        Intent intent = new Intent(this, Godziny.class);
        startActivity(intent);
    }

    /**
     * Otwiera ekran z archiwum zadan.
     */
    public void openArchiwum() {
        Intent intent = new Intent(this, ArchiwumZ.class);
        startActivity(intent);
    }
}