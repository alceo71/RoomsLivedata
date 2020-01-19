package com.example.roomslivedata.persistence.dao;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.roomslivedata.model.PianetaConSatelliti;

import java.util.List;

@Dao
public interface PianetaConSatellitiDao {

    @Transaction
    @Query("SELECT * FROM pianeta")
    public List<PianetaConSatelliti> findAll();

}
