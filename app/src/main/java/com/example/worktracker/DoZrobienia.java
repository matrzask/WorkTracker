package com.example.worktracker;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DoZrobienia extends AppCompatActivity {
    private Button button_back_zad1;


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
    }

    public void openZadania() {
        Intent intent = new Intent(this, Zadania.class);
        startActivity(intent);
    }
}