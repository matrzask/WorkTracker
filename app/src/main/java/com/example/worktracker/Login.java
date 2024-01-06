package com.example.worktracker;

import static com.example.worktracker.Database.addEmployee;
import static com.example.worktracker.Database.addUser;
import static com.example.worktracker.Database.login;
import static com.example.worktracker.R.*;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;

import java.util.ArrayList;
import java.util.Date;

public class Login extends AppCompatActivity {

    private Button registerButton;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_login);
        TextView username = (TextView) findViewById(id.username);
        TextInputLayout password = (TextInputLayout)  findViewById(id.password);
        TextInputEditText input_password = (TextInputEditText) findViewById(id.input_password);
        Button loginButton = (Button) findViewById(id.loginButton);
        registerButton = (Button) findViewById(id.registerButton);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if (username.getText().toString().equals("admin") && input_password.getText().toString().equals("admin")) {
                if (login(username.getText().toString(), input_password.getText().toString())) {
                    if(username.getText().toString().contains("manager")) openManagerScreen();
                    else openMainScreen();
                } else {
                    Toast.makeText(Login.this, "LOGIN FAILED !", Toast.LENGTH_SHORT).show();
                }
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRegisterMenu();
            }
        });
    }

    public void openMainScreen() {
        Intent intent = new Intent(this, WorkTrackerMainScreen.class);
        startActivity(intent);
    }

    public  void openRegisterMenu() {
        Intent intent = new Intent(this, Registration.class);
        startActivity(intent);
    }

    public void openManagerScreen() {
        Intent intent = new Intent(this, ManagerScreen.class);
        startActivity(intent);
    }
}