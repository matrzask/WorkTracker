package com.example.worktracker;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class DatabaseTest {
    @Test
    public void testGetEmployee() {
        assertEquals(Database.getEmployee("kSwJLfMLvRvbDAfj81NW").getFirstName(), "Jan");
        assertEquals(Database.getEmployee("kSwJLfMLvRvbDAfj81NW").getLastName(), "Kowalski");
        assertEquals(Database.getEmployee("kSwJLfMLvRvbDAfj81NW").getMiejscowosc(), "Kraków");
        assertEquals(Database.getEmployee("kSwJLfMLvRvbDAfj81NW").getId(), "kSwJLfMLvRvbDAfj81NW");
        assertEquals(Database.getEmployee("kSwJLfMLvRvbDAfj81NW").getKod(), "32-500");
        assertEquals(Database.getEmployee("kSwJLfMLvRvbDAfj81NW").getTelefon(), "214824724");
        assertEquals(Database.getEmployee("kSwJLfMLvRvbDAfj81NW").getEmail(), "kowaljan@prasoft.com");
        assertEquals(Database.getEmployee("kSwJLfMLvRvbDAfj81NW").getUlica(), "Kolarska 5");
    }

    @Test
    public void getWorkingHours() {
        assertEquals(Database.getWorkingHours("kSwJLfMLvRvbDAfj81NW").size(), 1);
    }

    @Test
    public void getWorkingHoursById() {
        assertEquals(Database.getWorkingHoursById("kSwJLfMLvRvbDAfj81NW", "1qPcEeh9a0nxBF1JV0E7").getGodziny(), 7.0, 1e-5);
    }


    @Test
    public void getTasks() {
        assertEquals(7, Database.getTasks("kSwJLfMLvRvbDAfj81NW").size());
    }

    @Test
    public void getTaskById() {
        assertEquals("case 5", Database.getTaskById("kSwJLfMLvRvbDAfj81NW","1FLfwQK94wwzuV17IgNk").getNazwa());
    }

    @Test
    public void addTask() {
    }

    @Test
    public void getHolidays() {
        assertEquals(1, Database.getHolidays("kSwJLfMLvRvbDAfj81NW").size());
    }

    @Test
    public void getHolidayById() {
        assertEquals(5, Database.getHolidayById("kSwJLfMLvRvbDAfj81NW", "CNhVog7TNHWoZa0jYMTC").getLiczbaDni());
    }

    @Test
    public void addHoliday() {
    }

    @Test
    public void login() {
        assertTrue(Database.login("kowaljan", "pass123"));
    }

    @Test
    public void getCurrentEmployee() {
        Database.login("anowak","qwerty1");
        assertEquals("Bgq6FdtER7DJKC47mEz5", Database.getCurrentEmployee().getId());
    }

    @Test
    public void setCurrentEmployee() {
    }

    @Test
    public void getCurrentEmployer() {
    }

    @Test
    public void addUser() {
    }
}