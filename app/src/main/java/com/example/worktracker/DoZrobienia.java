package com.example.worktracker;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DoZrobienia extends AppCompatActivity {
    private Button button_back_zad1;
    private Button task1;
    private Button task2;
    private Button task3;
    private Button task4;
    private Button task5;


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

        task1 = (Button) findViewById(R.id.task1);
        String r = Database.getTaskById("kSwJLfMLvRvbDAfj81NW", "I7iARlS8qoKRRcj3BTTZ").getNazwa();
        task1.setText(r);

        task2 = (Button) findViewById(R.id.task2);
        String t = Database.getTaskById("kSwJLfMLvRvbDAfj81NW", "qx5TUNmYLXEBTuJnS1Vu").getNazwa();
        task2.setText(t);

        task3 = (Button) findViewById(R.id.task3);
        String t3 = Database.getTaskById("kSwJLfMLvRvbDAfj81NW", "y6ObGxuUuKDutiDAQUnr").getNazwa();
        task3.setText(t3);

        task4 = (Button) findViewById(R.id.task4);
        String t4 = Database.getTaskById("kSwJLfMLvRvbDAfj81NW", "o6mkBERI4bWkyNcRmDW6").getNazwa();
        task4.setText(t4);

        task5 = (Button) findViewById(R.id.task5);
        String t5 = Database.getTaskById("kSwJLfMLvRvbDAfj81NW", "1FLfwQK94wwzuV17IgNk").getNazwa();
        task5.setText(t5);


        task1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = Database.getTaskById("kSwJLfMLvRvbDAfj81NW", "I7iARlS8qoKRRcj3BTTZ").getOpis();
                Toast.makeText(DoZrobienia.this, s, Toast.LENGTH_SHORT).show();
            }
        });

        task2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String u = Database.getTaskById("kSwJLfMLvRvbDAfj81NW", "qx5TUNmYLXEBTuJnS1Vu").getOpis();
                Toast.makeText(DoZrobienia.this, u, Toast.LENGTH_SHORT).show();
            }
        });

        task3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String u = Database.getTaskById("kSwJLfMLvRvbDAfj81NW", "y6ObGxuUuKDutiDAQUnr").getOpis();
                Toast.makeText(DoZrobienia.this, u, Toast.LENGTH_SHORT).show();
            }
        });

        task4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String u = Database.getTaskById("kSwJLfMLvRvbDAfj81NW", "o6mkBERI4bWkyNcRmDW6").getOpis();
                Toast.makeText(DoZrobienia.this, u, Toast.LENGTH_SHORT).show();
            }
        });

        task5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String u = Database.getTaskById("kSwJLfMLvRvbDAfj81NW", "1FLfwQK94wwzuV17IgNk").getOpis();
                Toast.makeText(DoZrobienia.this, u, Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void openZadania() {
        Intent intent = new Intent(this, Zadania.class);
        startActivity(intent);
    }
}