package com.example.worktracker;

import com.google.firebase.firestore.Exclude;

import java.util.Date;

public class WorkingHours {
    private String id;
    private Date data;
    private float godziny;

    public WorkingHours() {}
    public WorkingHours(Date data, float godziny) {
        this.data = data;
        this.godziny = godziny;
    }

    @Exclude
    public String getId() {
        return id;
    }
    public Date getData() {
        return data;
    }

    public float getGodziny() {
        return godziny;
    }

    public void setId(String id) {
        this.id = id;
    }
}
