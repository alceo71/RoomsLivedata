package com.example.roomslivedata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.roomslivedata.common.util.LogUtil;
import com.example.roomslivedata.model.Pianeta;
import com.example.roomslivedata.service.PianetaService;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // inizializzaPianeti();

    }

    public void inizializzaPianeti(){
        PianetaService pianetaService = new PianetaService(this);

        List<Pianeta> pianeti = datiPianeti();

        LogUtil.debug("Prima di insert");
        pianetaService.insert(pianeti);
        LogUtil.debug("Dopo di insert");
    }
    public List<Pianeta> datiPianeti(){
        List<Pianeta> result = new ArrayList<Pianeta>();

        result.add(new Pianeta("mercurio", 0.39,88, 1416, 0.06, 0.38,0));
        result.add(new Pianeta("venere", 0.72,225, 5832, 0.82, 0.95,0));
        result.add(new Pianeta("terra", 1,365, 24, 1, 1,1));
        result.add(new Pianeta("marte", 1.52,687, 25, 0.11, 0.53,2));
        result.add(new Pianeta("giove", 5.20,4380, 10, 317.89, 11.19,63));
        result.add(new Pianeta("saturno", 9.54,10585, 10, 95.15, 9.44,61));
        result.add(new Pianeta("urano", 19.2,30660, 18, 14.54, 4.10,27));
        result.add(new Pianeta("nettuno", 30.06,60225, 18, 17.23, 3.88,14));

        return result;
    }


}
