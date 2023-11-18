package com.example.worktracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView username = (TextView) findViewById(R.id.username);
        TextView password = (TextView)  findViewById(R.id.password);
        Button loginButton = (Button) findViewById(R.id.loginButton);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
                    openMainScreen();
                }else {
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