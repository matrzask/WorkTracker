package com.example.worktracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import java.util.ArrayList;

public class Godziny extends AppCompatActivity {

    private Button back4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_godziny);

        back4 = (Button) findViewById(R.id.button_back4);
        back4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openStatystyki();
            }
        });

        ScrollView scrollViewG = (ScrollView) findViewById(R.id.scrollViewG);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        Button buttonA = new Button(this);
        buttonA.setText("Data : Liczba godzin w ciągu dnia");
        linearLayout.addView(buttonA);

        ArrayList<WorkingHours> workingHours = Database.getWorkingHours(Database.getCurrentEmployee().getId());
        for(int i = 0; i < workingHours.size(); i++) {
            Button button = new Button(this);
            button.setText(workingHours.get(i).getData().toString().substring(0, 10) + " : " + workingHours.get(i).getGodziny() + " hours");
            button.setTextSize(16);
            linearLayout.addView(button);
        }
        scrollViewG.addView(linearLayout);

    }


    public void openStatystyki() {
        Intent intent = new Intent(this, Statystyki.class);
        startActivity(intent);
    }
}