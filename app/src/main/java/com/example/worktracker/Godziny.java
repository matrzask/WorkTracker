package com.example.worktracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
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

        LinearLayoutCompat.LayoutParams buttonLayoutParams = new LinearLayoutCompat.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        ArrayList<WorkingHours> workingHours = Database.getWorkingHours(Database.getCurrentEmployee().getId());
        for(int i = 0; i < workingHours.size(); i++) {
            Button button = new Button(this);
            button.setText(workingHours.get(i).getData().toString().substring(0, 10) + " : " + workingHours.get(i).getGodziny() + " hours");
            button.setTextSize(16);
            if(workingHours.get(i).getGodziny() < 8) button.setBackgroundColor(Color.rgb(255, 120, 120));
            else button.setBackgroundColor(Color.rgb(153, 255, 153));
            button.setLayoutParams(buttonLayoutParams);
            buttonLayoutParams.setMargins(10, 30, 10, 30);
            linearLayout.addView(button);

        }
        scrollViewG.addView(linearLayout);

    }


    public void openStatystyki() {
        Intent intent = new Intent(this, Statystyki.class);
        startActivity(intent);
    }
}