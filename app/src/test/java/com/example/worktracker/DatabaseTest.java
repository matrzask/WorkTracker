package com.example.worktracker;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

public class DatabaseTest {


    @org.junit.jupiter.api.Test
    public void testGetEmployee() {
        assertEquals(Database.getEmployee("kSwJLfMLvRvbDAfj81NW").getFirstName(), "Jan");
        assertEquals(Database.getEmployee("kSwJLfMLvRvbDAfj81NW").getFirstName(), "Kowalski");
        assertEquals(Database.getEmployee("kSwJLfMLvRvbDAfj81NW").getMiejscowosc(), "Kraków");
        assertEquals(Database.getEmployee("kSwJLfMLvRvbDAfj81NW").getId(), "kSwJLfMLvRvbDAfj81NW");
        assertEquals(Database.getEmployee("kSwJLfMLvRvbDAfj81NW").getKod(), "32-500");
        assertEquals(Database.getEmployee("kSwJLfMLvRvbDAfj81NW").getTelefon(), "214824724");
        assertEquals(Database.getEmployee("kSwJLfMLvRvbDAfj81NW").getEmail(), "kowaljan@prasoft.com");
        assertEquals(Database.getEmployee("kSwJLfMLvRvbDAfj81NW").getUlica(), "Kolarska 5");
    }
    @org.junit.jupiter.api.Test
    public void getWorkingHours() {
        assertEquals(Database.getWorkingHours("kSwJLfMLvRvbDAfj81NW").size(), 1);
    }

    @Test
    public void getWorkingHoursById() {
        assertEquals(Database.getWorkingHoursById("kSwJLfMLvRvbDAfj81NW", "1qPcEeh9a0nxBF1JV0E7").getGodziny(), 7.0);
    }


    @Test
    public void getTasks() {
        assertEquals(8, Database.getTasks("kSwJLfMLvRvbDAfj81NW").size());
    }

    @Test
    public void getTaskById() {
        assertEquals("case 5", Database.getTaskById("kSwJLfMLvRvbDAfj81NW","1FLfwQK94wwzuV17IgNk"));
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
        assertEquals("CNhVog7TNHWoZa0jYMTC", Database.getCurrentEmployee().getId());
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