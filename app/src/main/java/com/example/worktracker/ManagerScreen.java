package com.example.worktracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.DocumentReference;

import java.util.ArrayList;

public class ManagerScreen extends AppCompatActivity {

    private TextView managerName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_screen);

        managerName = (TextView) findViewById(R.id.manager_name);
        String s = "Witaj " + Database.getCurrentEmployee().getFirstName()+ " " + Database.getCurrentEmployee().getLastName();
        managerName.setText(s);

        ScrollView scrollViewManager = (ScrollView) findViewById(R.id.scrollViewManager);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        ArrayList<DocumentReference> employees = Database.getCurrentEmployee().getPodwladni();
        LinearLayoutCompat.LayoutParams buttonLayoutParams = new LinearLayoutCompat.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        for(int i = 0; i < employees.size(); i++) {
            Button button = new Button(this);
            String buttonText = Database.getEmployee(employees.get(i).getId()).getFirstName() +" "+ Database.getEmployee(employees.get(i).getId()).getLastName();
            button.setText(buttonText);
            button.setBackgroundColor(Color.rgb(0, 255, 200));
            button.setLayoutParams(buttonLayoutParams);
            buttonLayoutParams.setMargins(10, 30, 10, 30);
            linearLayout.addView(button);
            int finalI = i;
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Database.setCurrentEmployee(Database.getEmployee(employees.get(finalI).getId()), Database.getCurrentEmployee());
                    openInfoPracownik();
                }
            });
        }

        scrollViewManager.addView(linearLayout);

        Button wyloguj = (Button) findViewById(R.id.logout);
        wyloguj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLogin();
            }
        });

    }

    public void openInfoPracownik() {
        Intent intent = new Intent(this, InfoPracownik.class);
        startActivity(intent);
    }

    public void openLogin() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}