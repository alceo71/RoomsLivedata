package com.example.roomslivedata.persistence.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.roomslivedata.model.Satellite;

import java.util.List;

@Dao
public interface SatelliteDao {

    @Query("SELECT * FROM satellite")
    List<Satellite> findAll();

    @Insert
    void insert(Satellite pianeta);

    @Insert
    void insert(List<Satellite> pianeti);

    @Delete
    void delete(Satellite pianeta);

    @Update
    void update(Satellite pianeta);


}
