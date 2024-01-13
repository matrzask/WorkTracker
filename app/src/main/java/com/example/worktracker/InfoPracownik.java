package com.example.worktracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Klasa reprezentuje ekran przedstawiajacy dane wybranego pracownika, takie jak:
 * numer telefonu, email, date urodzenia oraz adres.
 * Dodatkowo zawiera przyciski: 'ZOBACZ GODZINY', 'ZOBACZ TASKI' i 'DODAJ TASK'.
 * */
public class InfoPracownik extends AppCompatActivity {
    /**
     * Tworzy ekran z informacjami na temat pracownika.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_pracownik);

        TextView pracownik = (TextView) findViewById(R.id.name);
        String names = Database.getCurrentEmployee().getFirstName() + " " + Database.getCurrentEmployee().getLastName();
        pracownik.setText(names);

        TextView telefon = (TextView) findViewById(R.id.telefon);
        String numer = Database.getCurrentEmployee().getTelefon();
        telefon.setText(numer);

        TextView email = (TextView) findViewById(R.id.mail);
        String adresMailowy = Database.getCurrentEmployee().getEmail();
        email.setText(adresMailowy);

        TextView ulica = (TextView) findViewById(R.id.street);
        String street = "Adres: " + Database.getCurrentEmployee().getUlica();
        ulica.setText(street);

        TextView kod = (TextView) findViewById(R.id.code);
        String kodPocztowy = Database.getCurrentEmployee().getKod();
        kod.setText(kodPocztowy);

        TextView town = (TextView) findViewById(R.id.town);
        String towns = Database.getCurrentEmployee().getMiejscowosc();
        town.setText(towns);

        TextView date = (TextView) findViewById(R.id.birthDate);
        String dates = "Data urodzenia: " + Database.getCurrentEmployee().getBirthDate().toString().substring(4, 10) + Database.getCurrentEmployee().getBirthDate().toString().substring(23, 28);
        date.setText(dates);



        Button viewHours = (Button) findViewById(R.id.zobaczGodziny);
        viewHours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openViewHours();
            }
        });

        Button viewTasks = (Button) findViewById(R.id.zobaczTaski);
        viewTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openViewTasks();
            }
        });

        Button addTask = (Button) findViewById(R.id.dodajTask);
        addTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddTask();
            }
        });

        Button back = (Button) findViewById(R.id.button_backM);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Database.setCurrentEmployee(Database.getCurrentEmployer(), Database.getCurrentEmployer());
                openMainMenu();
            }
        });
    }

    /**
     * Otwiera ekran dla przelozonego, aby zobaczyl godziny pracy swojego pracownika.
     */
    public void openViewHours() {
        Intent intent = new Intent(this, ViewHours.class);
        startActivity(intent);
    }

    /**
     * Otwiera ekran dla przelozonego, aby zobaczyl taski swojego pracownika.
     */
    public void openViewTasks() {
        Intent intent = new Intent(this, ViewTasks.class);
        startActivity(intent);
    }

    /**
     * Otwiera ekran dla przelozonego, aby dodal task swojemu pracownikowi.
     */
    public void openAddTask() {
        Intent intent = new Intent(this, AddTask.class);
        startActivity(intent);
    }

    /**
     * Wraca do ekranu ze wszystkimi pracownikami przelozonego.
     */
    public void openMainMenu() {
        Intent intent = new Intent(this, ManagerScreen.class);
        startActivity(intent);
    }
}