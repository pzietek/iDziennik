package com.example.idziennik.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface SubjectDao {
    @Query("SELECT * FROM Subject")
    List<Subject> getAll();

    @Query("SELECT * FROM Subject WHERE id = :id")
    Subject getById(int id);

    @Insert
    void insert(Subject subject);

    @Delete
    void delete(Subject subject);

    @Update
    void update(Subject subject);

    @Query("DELETE FROM Subject")
    void deleteAll();
}
