package com.example.idziennik.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface GradeDao {
    @Query("SELECT * FROM Grade")
    List<Grade> getAll();

    @Query("SELECT * FROM Grade WHERE id = :id")
    Grade getById(int id);

    @Query("SELECT * FROM Grade WHERE type = :typ ")
    List<Grade> getGrades(char typ);

    @Insert
    void insert(Grade grade);

    @Delete
    void delete(Grade grade);

    @Update
    void update(Grade grade);

    @Query("DELETE FROM Grade")
    void deleteAll();
}
