package com.example.worktracker;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.ArrayList;

public class WTrakcie extends AppCompatActivity {
    private Button button_back_zad2;
    private Button traktat1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wtrakcie);

        button_back_zad2 = (Button) findViewById(R.id.button_back_zad2);
        button_back_zad2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openZadania();
            }
        });
        ScrollView scrollView2 = (ScrollView) findViewById(R.id.scrollView2);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        ArrayList<Tasks> tasks =  Database.getTasks(Database.getCurrentEmployee().getId());

        for(int i = 0; i < tasks.size(); i++) {
            if(tasks.get(i).getStatus().equals("W trakcie")) {
                Button button = new Button(this);
                linearLayout.addView(button);
                Tasks task = tasks.get(i);
                button.setText(task.getNazwa());

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(WTrakcie.this, task.getOpis(), Toast.LENGTH_SHORT).show();
                    }
                });



            }
        }
        scrollView2.addView(linearLayout);
    }

    public void openZadania() {
        Intent intent = new Intent(this, Zadania.class);
        startActivity(intent);
    }
}