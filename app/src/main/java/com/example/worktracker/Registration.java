package com.example.worktracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Registration extends AppCompatActivity {
    private Button buttonBackReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        buttonBackReg = (Button) findViewById(R.id.buttonBackReg);

        buttonBackReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainMenu();
            }
        });
    }

    public void openMainMenu() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}