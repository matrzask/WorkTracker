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
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Klasa reprezentuje ekran wyswietlajacy liste godzin pracy pracownikowi
 * z podzialem na dni.
 * */
public class Godziny extends AppCompatActivity {

    private Button back4;

    /**
     * Tworzy ekran z godzinami pracy pracownika.
     * @param savedInstanceState
     */
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
            String s = workingHours.get(i).getData().toString().substring(0, 10) + workingHours.get(i).getData().toString().substring(23, 28) + " : " + workingHours.get(i).getGodziny() + " hours";
            button.setText(s);
            button.setTextSize(16);
            if(workingHours.get(i).czyOsiemGodzin()) button.setBackgroundColor(Color.rgb(255, 120, 120));
            else button.setBackgroundColor(Color.rgb(153, 255, 153));
            button.setLayoutParams(buttonLayoutParams);
            buttonLayoutParams.setMargins(10, 30, 10, 30);
            int finalI = i;
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(Godziny.this, workingHours.get(finalI).getCzasRozpoczecia() + " : " + workingHours.get(finalI).getCzasZakonczenia(), Toast.LENGTH_SHORT).show();
                }
            });
            linearLayout.addView(button);

        }
        scrollViewG.addView(linearLayout);

    }


    /**
     * Wraca do ekranu z wyborem rodzaju statystyki.
     */
    public void openStatystyki() {
        Intent intent = new Intent(this, Statystyki.class);
        startActivity(intent);
    }
}