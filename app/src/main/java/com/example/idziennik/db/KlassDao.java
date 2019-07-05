package com.example.idziennik.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface KlassDao {
    @Query("SELECT * FROM Klass")
    List<Klass> getAll();

    @Query("SELECT * FROM Klass WHERE id = :id")
    Klass getById(int id);

    @Insert
    void insert(Klass klass);

    @Delete
    void delete(Klass klass);

    @Update
    void update(Klass klass);

    @Query("DELETE FROM Klass")
    void deleteAll();
}
