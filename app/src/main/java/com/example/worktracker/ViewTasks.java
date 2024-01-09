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
import java.util.Comparator;

public class ViewTasks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_tasks);

        Button backButton = (Button) findViewById(R.id.buttonBackTask);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openInfo();
            }
        });

        ScrollView scrollView = (ScrollView) findViewById(R.id.scrollViewTM);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        TextView name = (TextView) findViewById(R.id.name2);
        String nam = Database.getCurrentEmployee().getFirstName() + " " + Database.getCurrentEmployee().getLastName();
        name.setText(nam);

        Button buttonA = new Button(this);
        buttonA.setText("Zadanie : status zadania");
        linearLayout.addView(buttonA);

        ArrayList<Tasks> tasks = Database.getTasks(Database.getCurrentEmployee().getId());
        tasks.sort(new Comparator<Tasks>() {
            @Override
            public int compare(Tasks tasks, Tasks t1) {
                return tasks.getStatus().compareTo(t1.getStatus());
            }
        });
        LinearLayoutCompat.LayoutParams buttonLayoutParams = new LinearLayoutCompat.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        for(int i=0; i < tasks.size(); i++) {
            Button button = new Button(this);
            String s = tasks.get(i).getNazwa() + " : " + tasks.get(i).getStatus();
            button.setText(s);
            if(tasks.get(i).getStatus().equals("Do zrobienia"))
                button.setBackgroundColor(Color.rgb(255, 140, 140));
            else if(tasks.get(i).getStatus().equals("W trakcie"))
                button.setBackgroundColor(Color.rgb(255, 255, 140));
            else button.setBackgroundColor(Color.rgb(140, 255, 140));
            button.setLayoutParams(buttonLayoutParams);
            buttonLayoutParams.setMargins(10, 30, 10, 30);
            linearLayout.addView(button);
        }

        scrollView.addView(linearLayout);

    }

    public void openInfo() {
        Intent intent = new Intent(this, InfoPracownik.class);
        startActivity(intent);
    }
}