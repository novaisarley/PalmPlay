package com.br.arley.projeto2020;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.br.arley.projeto2020.adapter.DesafiosAdapter;
import com.br.arley.projeto2020.model.Desafio;

import java.util.ArrayList;
import java.util.List;

public class ListaActivity extends AppCompatActivity {
    ListView ListDesafios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        ListDesafios =  findViewById(R.id.activity_lista_lv_desafio);

        List<Desafio> desafioslist = new ArrayList<Desafio>();
        desafioslist.add(new Desafio("Descriçãozinha, bem zinha mesmo", "Nome da atv", "@drawable/vector.png", "@drawable/elipse.png"));
        desafioslist.add(new Desafio("Descriçãozinha, bem zinha mesmo", "Nome da atv", "@drawable/vector.png", "@drawable/elipse.png"));
        desafioslist.add(new Desafio("Descriçãozinha, bem zinha mesmo", "Nome da atv", "@drawable/vector.png", "@drawable/elipse.png"));
        desafioslist.add(new Desafio("Descriçãozinha, bem zinha mesmo", "Nome da atv", "@drawable/vector.png", "@drawable/elipse.png"));desafioslist.add(new Desafio("Descriçãozinha, bem zinha mesmo", "Nome da atv", "@drawable/vector.png", "@drawable/elipse.png"));
        desafioslist.add(new Desafio("Descriçãozinha, bem zinha mesmo", "Nome da atv", "@drawable/vector.png", "@drawable/elipse.png"));
        desafioslist.add(new Desafio("Descriçãozinha, bem zinha mesmo", "Nome da atv", "@drawable/vector.png", "@drawable/elipse.png"));
        desafioslist.add(new Desafio("Descriçãozinha, bem zinha mesmo", "Nome da atv", "@drawable/vector.png", "@drawable/elipse.png"));
        DesafiosAdapter adapter = new DesafiosAdapter(desafioslist, this);

        ListDesafios.setAdapter(adapter);
    }
}
