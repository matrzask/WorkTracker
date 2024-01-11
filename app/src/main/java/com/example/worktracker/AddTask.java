package com.example.worktracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Klasa reprezentuje ekran sluzacy do dodawania nowych zadan(taskow) pracownikom.
 * Zawiera 2 pola tekstowe umozliwiajace podanie nazwy zadania i opisu oraz
 * przyciski 'DODAJ TASK' i 'POWROT'.
 * */
public class AddTask extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        Button buttonBack = (Button) findViewById(R.id.buttonBackAdd);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openInfo();
            }
        });

        TextView viewName = (TextView) findViewById(R.id.name3);
        String s = Database.getCurrentEmployee().getFirstName() + Database.getCurrentEmployee().getLastName();
        viewName.setText(s);

        TextView taskName = (TextView) findViewById(R.id.enterName);
        TextView taskOpis = (TextView) findViewById(R.id.enterOpis);

        Button addTaskButton = (Button) findViewById(R.id.addTaskButton);
        addTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Database.addTask(Database.getCurrentEmployee().getId(), taskName.getText().toString(), taskOpis.getText().toString());
            }
        });

    }

    public void openInfo() {
        Intent intent = new Intent(this, InfoPracownik.class);
        startActivity(intent);
    }
}