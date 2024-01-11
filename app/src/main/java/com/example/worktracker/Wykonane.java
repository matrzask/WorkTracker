package com.example.worktracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Klasa reprezentuje ekran ukazujacy obecne zadania danego pracownika o statusie 'wykonane'.
 * Nacisniecie zadania wyswietla jego opis.
 * */
public class Wykonane extends AppCompatActivity {
    private Button button_back_zad3;
    private Button wyk1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wykonane);

        button_back_zad3 = (Button) findViewById(R.id.button_back_zad3);
        button_back_zad3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openZadania();
            }
        });

        ScrollView scrollView3 = (ScrollView) findViewById(R.id.scrollView3);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        ArrayList<Tasks> tasks =  Database.getTasks(Database.getCurrentEmployee().getId());
        LinearLayoutCompat.LayoutParams buttonLayoutParams = new LinearLayoutCompat.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        for(int i = 0; i < tasks.size(); i++) {
            if(tasks.get(i).getStatus().equals("Wykonane")) {
                Button button = new Button(this);
                linearLayout.addView(button);
                Tasks task = tasks.get(i);
                button.setText(task.getNazwa());
                button.setBackgroundColor(Color.rgb(140, 255, 140));
                button.setLayoutParams(buttonLayoutParams);
                buttonLayoutParams.setMargins(10, 30, 10, 30);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(Wykonane.this, task.getOpis(), Toast.LENGTH_SHORT).show();
                    }
                });



            }
        }
        scrollView3.addView(linearLayout);
    }

    public void openZadania() {
        Intent intent = new Intent(this, Zadania.class);
        startActivity(intent);
    }


}