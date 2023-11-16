package com.example.worktracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Statystyki extends AppCompatActivity {
    private Button button_back2;

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
    }

    public void openMainMenu() {
        Intent intent = new Intent(this, WorkTrackerMainScreen.class);
        startActivity(intent);
    }
}