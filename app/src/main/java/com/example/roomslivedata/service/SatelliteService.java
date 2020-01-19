package com.example.roomslivedata.service;

import android.content.Context;

import com.example.roomslivedata.model.Satellite;
import com.example.roomslivedata.persistence.SistemaSolareDatabase;
import com.example.roomslivedata.persistence.dao.SatelliteDao;

public class SatelliteService {


    private static Context context;

    public SatelliteService(Context context) {
        this.context = context;
    }

    public void insert(Satellite satellite){

        // Crea il db
        SistemaSolareDatabase db = SistemaSolareDatabase.getDatabase(context);
        // Recupera il DAO
        SatelliteDao dao = db.satelliteDao();
        dao.insert(satellite);

    }

}
