package com.example.worktracker;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class WTrakcie extends AppCompatActivity {
    private Button button_back_zad2;
    private Button traktat1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wtrakcie);

        button_back_zad2 = (Button) findViewById(R.id.button_back_zad2);
        button_back_zad2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openZadania();
            }
        });

        traktat1 = (Button) findViewById(R.id.traktat1);
        String s = Database.getTaskById("kSwJLfMLvRvbDAfj81NW", "tOJAduUVvR3hX7GmlQ9x").getNazwa();
        traktat1.setText(s);

        traktat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String u = Database.getTaskById("kSwJLfMLvRvbDAfj81NW", "tOJAduUVvR3hX7GmlQ9x").getOpis();
                Toast.makeText(WTrakcie.this, u, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void openZadania() {
        Intent intent = new Intent(this, Zadania.class);
        startActivity(intent);
    }
}