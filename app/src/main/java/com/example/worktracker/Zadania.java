package com.example.worktracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Zadania extends AppCompatActivity {
    private Button button_back;
    private Button button_doz;
    private Button button_wtr;
    private Button button_wyk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zadania);

        button_back = (Button) findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainMenu();
            }
        });

        button_doz = (Button) findViewById(R.id.button_doz);
        button_doz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDoZrobienia();
            }
        });

        button_wtr = (Button) findViewById(R.id.button_wtr);
        button_wtr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWTrakcie();
            }
        });

        button_wyk = (Button) findViewById(R.id.button_wyk);
        button_wyk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWykonane();
            }
        });
    }

    public void openMainMenu() {
        Intent intent = new Intent(this, WorkTrackerMainScreen.class);
        startActivity(intent);
    }

    public void openDoZrobienia() {
        Intent intent = new Intent(this, DoZrobienia.class);
        startActivity(intent);
    }

    public void openWTrakcie() {
        Intent intent = new Intent(this, WTrakcie.class);
        startActivity(intent);
    }

    public void openWykonane() {
        Intent intent = new Intent(this, Wykonane.class);
        startActivity(intent);
    }
}