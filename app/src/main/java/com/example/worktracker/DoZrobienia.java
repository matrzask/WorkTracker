package com.example.worktracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Klasa reprezentuje ekran ukazujacy obecne zadania danego pracownika o statusie 'do zrobienia'.
 * Nacisniecie zadania wyswietla jego opis.
 * */
public class DoZrobienia extends AppCompatActivity {
    private Button button_back_zad1;


    /**
     * Tworzy ekran zadan do zrobienia.
     * @param savedInstanceState
     */
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do_zrobienia);

        button_back_zad1 = (Button) findViewById(R.id.button_back_zad1);
        button_back_zad1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openZadania();
            }
        });

        ScrollView scrollView1 = (ScrollView) findViewById(R.id.scrollView1);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        ArrayList<Tasks> tasks =  Database.getTasks(Database.getCurrentEmployee().getId());
        LinearLayoutCompat.LayoutParams buttonLayoutParams = new LinearLayoutCompat.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        for(int i = 0; i < tasks.size(); i++) {
            if(tasks.get(i).getStatus().equals("Do zrobienia")) {
                Button button = new Button(this);
                linearLayout.addView(button);
                Tasks task = tasks.get(i);
                button.setText(task.getNazwa());
                button.setBackgroundColor(Color.rgb(255, 140, 140));
                button.setLayoutParams(buttonLayoutParams);
                buttonLayoutParams.setMargins(10, 30, 10, 30);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(DoZrobienia.this, task.getOpis(), Toast.LENGTH_SHORT).show();
                    }
                });



            }
        }
        scrollView1.addView(linearLayout);

    }


    /**
     * Wraca do ekranu z wyborem rodzajow zadan.
     */
    public void openZadania() {
        Intent intent = new Intent(this, Zadania.class);
        startActivity(intent);
    }
}