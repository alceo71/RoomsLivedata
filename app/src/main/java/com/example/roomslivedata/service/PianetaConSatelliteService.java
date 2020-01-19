package com.example.roomslivedata.service;

import android.content.Context;

import com.example.roomslivedata.model.PianetaConSatelliti;
import com.example.roomslivedata.persistence.SistemaSolareDatabase;
import com.example.roomslivedata.persistence.dao.PianetaConSatellitiDao;

import java.util.List;

public class PianetaConSatelliteService {

    private static Context context;


    public PianetaConSatelliteService(Context context){
        this.context = context;
    }


    public List<PianetaConSatelliti> findAll(){
        // Crea il db
        SistemaSolareDatabase db = SistemaSolareDatabase.getDatabase(context);
        // Recupera il DAO
        PianetaConSatellitiDao dao = db.pianetaConSatellitiDao();
        // Recupera tutti i pianeti
        return dao.findAll();
    }

}
