package com.example.worktracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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

        wyk1 = (Button) findViewById(R.id.wyk1);
        String s = Database.getTaskById("kSwJLfMLvRvbDAfj81NW", "LZyTKidd93oHAGtXbS61").getNazwa();
        wyk1.setText(s);

        wyk1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String u = Database.getTaskById("kSwJLfMLvRvbDAfj81NW", "LZyTKidd93oHAGtXbS61").getOpis();
                Toast.makeText(Wykonane.this, u, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void openZadania() {
        Intent intent = new Intent(this, Zadania.class);
        startActivity(intent);
    }


}