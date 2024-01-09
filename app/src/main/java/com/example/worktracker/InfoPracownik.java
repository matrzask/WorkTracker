package com.example.worktracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class InfoPracownik extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_pracownik);

        TextView pracownik = (TextView) findViewById(R.id.titleWorker);
        pracownik.setText(Database.getCurrentEmployee().getFirstName());


    }
}