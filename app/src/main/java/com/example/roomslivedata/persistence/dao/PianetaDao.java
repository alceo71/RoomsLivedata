package com.example.roomslivedata.persistence.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.roomslivedata.model.Pianeta;

import java.util.List;

@Dao
public interface PianetaDao {

    @Query("SELECT * FROM pianeta")
    LiveData<List<Pianeta>> findAll();

    @Query("SELECT * FROM pianeta WHERE numero_satelliti > 0")
    List<Pianeta> findConSatelliti();

    @Query("SELECT * FROM pianeta WHERE nome = :nome")
    Pianeta findPerNome(String nome);

    @Insert
    void insert(Pianeta pianeta);

    @Insert
    void insert(List<Pianeta> pianeti);

    @Delete
    void delete(Pianeta pianeta);

    @Update
    void update(Pianeta pianeta);

}
