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
import android.widget.TextView;

import java.util.ArrayList;

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
        int value = 0;
        ArrayList<Holiday> holidays = Database.getHolidays(Database.getCurrentEmployee().getId());
        for(int i = 0; i < holidays.size(); i++) {
            value += holidays.get(i).getLiczbaDni();
        }

        String rest = Integer.toString(value);
        restDays.setText(rest);

        haveDays = (TextView) findViewById(R.id.haveDays);
        int value2 = 26 - value;
        String have = Integer.toString(value2);
        haveDays.setText(have);

        ScrollView scrollViewH = (ScrollView) findViewById(R.id.scrollViewH);
        LinearLayoutCompat.LayoutParams buttonLayoutParams = new LinearLayoutCompat.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        for(int i = 0; i < holidays.size(); i++) {
            Button button = new Button(this);
            String s = holidays.get(i).getDataRozpoczecia().toString().substring(0, 10) + holidays.get(i).getDataRozpoczecia().toString().substring(23, 28) + " : " + holidays.get(i).getDataZakonczenia().toString().substring(0, 10) + holidays.get(i).getDataZakonczenia().toString().substring(23, 28);
            button.setText(s);
            button.setBackgroundColor(Color.rgb(200, 200, 200));
            button.setLayoutParams(buttonLayoutParams);
            buttonLayoutParams.setMargins(10, 30, 10, 30);
            linearLayout.addView(button);
        }
        scrollViewH.addView(linearLayout);
    }

    public void openStatystyki() {
        Intent intent = new Intent(this, Statystyki.class);
        startActivity(intent);
    }
}