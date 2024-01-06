package com.example.worktracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Comparator;

public class ArchiwumZ extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archiwum_z);

        Button button5 = (Button) findViewById(R.id.button_back5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openStatystyki();
            }
        });

        ScrollView scrollViewA = (ScrollView) findViewById(R.id.scrollViewA);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        Button beginBut = new Button(this);
        beginBut.setText("data : status");
        linearLayout.addView(beginBut);

        ArrayList<Tasks> tasks =  Database.getTasks(Database.getCurrentEmployee().getId());

        for(int i = 0; i < tasks.size(); i++) {
            Button button = new Button(this);
            linearLayout.addView(button);
            Tasks task = tasks.get(i);
            button.setText(task.getNazwa() + " : " + task.getStatus());
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(ArchiwumZ.this, task.getOpis(), Toast.LENGTH_SHORT).show();
                }
            });
        }
        scrollViewA.addView(linearLayout);


    }

    public void openStatystyki() {
        Intent intent = new Intent(this, Statystyki.class);
        startActivity(intent);
    }
}