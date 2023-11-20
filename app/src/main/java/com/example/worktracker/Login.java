package com.example.worktracker;

import static com.example.worktracker.Database.addEmployee;
import static com.example.worktracker.Database.login;

import androidx.appcompat.app.AppCompatActivity;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView username = (TextView) findViewById(R.id.username);
        TextInputLayout password = (TextInputLayout)  findViewById(R.id.password);
        TextInputEditText input_password = (TextInputEditText) findViewById(R.id.input_password);
        Button loginButton = (Button) findViewById(R.id.loginButton);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if (username.getText().toString().equals("admin") && input_password.getText().toString().equals("admin")) {
                if (login(username.getText().toString(), input_password.getText().toString())) {
                    openMainScreen();
                } else {
                    Toast.makeText(Login.this, "LOGIN FAILED !", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void openMainScreen() {
        Intent intent = new Intent(this, WorkTrackerMainScreen.class);
        startActivity(intent);
    }
}