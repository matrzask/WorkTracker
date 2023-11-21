package com.example.worktracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Urlopy extends AppCompatActivity {
    private Button back_stat;
    private TextView restDays;
    private TextView haveDays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urlopy);

        back_stat = (Button) findViewById(R.id.button_back3);
        back_stat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openStatystyki();
            }
        });

        restDays = (TextView) findViewById(R.id.restDays);
        int value = Database.getHolidayById("kSwJLfMLvRvbDAfj81NW", "CNhVog7TNHWoZa0jYMTC").getLiczbaDni();
        String rest = Integer.toString(value);
        restDays.setText(rest);

        haveDays = (TextView) findViewById(R.id.haveDays);
        int value2 = 20 - value;
        String have = Integer.toString(value2);
        haveDays.setText(have);


    }

    public void openStatystyki() {
        Intent intent = new Intent(this, Statystyki.class);
        startActivity(intent);
    }
}