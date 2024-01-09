package com.example.worktracker;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
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

        for(int i = 0; i < employees.size(); i++) {
            Button button = new Button(this);
            button.setText(Database.getEmployee(employees.get(i).getId()).getFirstName() +" "+ Database.getEmployee(employees.get(i).getId()).getLastName());
            linearLayout.addView(button);
            int finalI = i;
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Database.setCurrentEmployee(Database.getEmployee(employees.get(finalI).getId()));
                    openInfoPracownik();
                }
            });
        }

        scrollViewManager.addView(linearLayout);

    }

    public void openInfoPracownik() {
        Intent intent = new Intent(this, InfoPracownik.class);
        startActivity(intent);
    }
}