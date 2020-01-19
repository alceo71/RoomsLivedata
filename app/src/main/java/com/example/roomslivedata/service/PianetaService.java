package com.example.roomslivedata.service;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import com.example.roomslivedata.common.util.LogUtil;
import com.example.roomslivedata.model.Pianeta;
import com.example.roomslivedata.persistence.SistemaSolareDatabase;
import com.example.roomslivedata.persistence.dao.PianetaDao;

import java.util.List;

public class PianetaService {

    private static Context context;


    public PianetaService(Context context){
        this.context = context;
    }

    /**
     * Trova tutti i pianeti
     *
     * @return
     */
    public LiveData<List<Pianeta>> findAll(){
        // Crea il db
        SistemaSolareDatabase db = SistemaSolareDatabase.getDatabase(context);
        // Recupera il DAO
        PianetaDao dao = db.pianetaDao();
        // Recupera tutti i pianeti
        return dao.findAll();
    }

    /**
     * Trova tutti i pianeti con almeno un satellite
     *
     * @return
     */
    public List<Pianeta> findConSatelliti(){
        // Crea il db
        SistemaSolareDatabase db = SistemaSolareDatabase.getDatabase(context);
        // Recupera il DAO
        PianetaDao dao = db.pianetaDao();
        // Recupera tutti i pianeti
        return dao.findConSatelliti();
    }

    /**
     * Trova tutti i pianeti con almeno un satellite
     *
     * @return
     */
    public Pianeta getPerNome(String nome){
        // Crea il db
        SistemaSolareDatabase db = SistemaSolareDatabase.getDatabase(context);
        // Recupera il DAO
        PianetaDao dao = db.pianetaDao();
        // Recupera tutti i pianeti
        return dao.findPerNome(nome);
    }


    public void insert(Pianeta pianeta){
        // Crea il db
        SistemaSolareDatabase db = SistemaSolareDatabase.getDatabase(context);
        // Recupera il DAO
        PianetaDao dao = db.pianetaDao();
        dao.insert(pianeta);
    }

    public void insert(final List<Pianeta> pianeti){
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... voids) {
                LogUtil.debug("Inizio creazione pianeti nel database");
                // Crea il db
                SistemaSolareDatabase db = SistemaSolareDatabase.getDatabase(context);
                // Recupera il DAO
                PianetaDao dao = db.pianetaDao();
                dao.insert(pianeti);
                db.close();
                LogUtil.debug("Fine creazione pianeti nel database");
                return null;
            }
        }.execute();
    }




}
