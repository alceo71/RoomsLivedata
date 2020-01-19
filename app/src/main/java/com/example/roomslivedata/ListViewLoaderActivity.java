package com.example.roomslivedata;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import com.example.roomslivedata.common.util.LogUtil;
import com.example.roomslivedata.model.Pianeta;
import com.example.roomslivedata.service.PianetaService;

import java.util.List;

public class ListViewLoaderActivity extends AppCompatActivity {

    // L'adapter per un oggetto Pianeta
    // Dobbiamo dichiararlo come attributo della classe perché verrà usato dai metodi di <i>LoaderManager.LoaderCallbacks</i>
    private PianetiAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_loader);

        setTitle(getString(R.string.titolo_loader));

        // Crea un Adapter per il Pianeta
        adapter = new PianetiAdapter(this, R.layout.pianeta);

        // Recupera la lista view e assegna l'adapter
        ListView listaPianeti = (ListView) findViewById(R.id.lista_pianeti);
        listaPianeti.setAdapter(adapter);


        // Recupera i dati dei pianeti
        PianetaService service = new PianetaService(this);

        service.findAll().observe(this, new Observer<List<Pianeta>>() {
            @Override
            public void onChanged(List<Pianeta> pianeti) {
                LogUtil.debug("Oggetto pianeti modificato");
                adapter.clear();
                adapter.addAll(pianeti);
            }
        });

    }


}
