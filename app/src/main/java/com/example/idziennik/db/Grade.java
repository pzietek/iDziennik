package com.example.idziennik.db;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Grade implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private int value;
    private int subject_id;
    private int student_id;
    private char type;

    public Grade(int id, int value, int subject_id, int student_id, char type) {
        this.id = id;
        this.value = value;
        this.subject_id = subject_id;
        this.student_id = student_id;
        this.type = type; // s for sprawdzian, k for kartkowka, o for odpowiedz
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }
}
