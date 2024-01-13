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
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Klasa reprezentuje ekran wyswietlajacy liste godzin pracy podwladnego pracownika
 * z podzialem na dni.
 * */
public class ViewHours extends AppCompatActivity {
    /**
     * Tworzy ekran z godzinami pracy podwladnego.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_hours);

        ScrollView scrollView = (ScrollView) findViewById(R.id.scrollViewHM);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        TextView name = (TextView) findViewById(R.id.name);
        String nam = Database.getCurrentEmployee().getFirstName() + " " + Database.getCurrentEmployee().getLastName();
        name.setText(nam);


        Button buttonA = new Button(this);
        buttonA.setText("Data : Liczba godzin w ciągu dnia");
        linearLayout.addView(buttonA);

        ArrayList<WorkingHours> hours = Database.getWorkingHours(Database.getCurrentEmployee().getId());
        LinearLayoutCompat.LayoutParams buttonLayoutParams = new LinearLayoutCompat.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        for(int i=0; i < hours.size(); i++) {
            Button button = new Button(this);
            String s = hours.get(i).getData().toString().substring(4, 10) + hours.get(i).getData().toString().substring(23, 28) + " : " + hours.get(i).getGodziny() + " HOURS";
            button.setText(s);
            if(hours.get(i).czyOsiemGodzin()) button.setBackgroundColor(Color.rgb(255, 120, 120));
            else button.setBackgroundColor(Color.rgb(153, 255, 153));
            button.setLayoutParams(buttonLayoutParams);
            buttonLayoutParams.setMargins(10, 30, 10, 30);
            int finalI = i;
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(ViewHours.this, hours.get(finalI).getCzasRozpoczecia() + " : " + hours.get(finalI).getCzasZakonczenia(), Toast.LENGTH_SHORT).show();
                }
            });
            linearLayout.addView(button);
        }

        scrollView.addView(linearLayout);


        Button backButton = (Button) findViewById(R.id.buttonBackGodz);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openInfo();
            }
        });

    }

    /**
     * Wraca do ekranu z informacjami na temat pracownika.
     */
    public void openInfo() {
        Intent intent = new Intent(this, InfoPracownik.class);
        startActivity(intent);
    }

}