package com.br.arley.projeto2020;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.br.arley.projeto2020.adapter.DesafiosAdapter;
import com.br.arley.projeto2020.model.Desafio;
import com.br.arley.projeto2020.model.MyRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListaActivity extends AppCompatActivity {

    RecyclerView recyclerViewDesafios;
    MyRecyclerViewAdapter desafiosAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        recyclerViewDesafios =  findViewById(R.id.activity_lista_rv_desafio);
        recyclerViewDesafios.setLayoutManager(new LinearLayoutManager(this));

        List<Desafio> desafioslist = new ArrayList<Desafio>();
        desafioslist.add(new Desafio("Descriçãozinha, bem zinha mesmo", "Nome da atv", "@drawable/vector.png"));
        desafioslist.add(new Desafio("Descriçãozinha, bem zinha mesmo", "Nome da atv", "@drawable/vector.png"));
        desafioslist.add(new Desafio("Descriçãozinha, bem zinha mesmo", "Nome da atv", "@drawable/vector.png"));
        desafioslist.add(new Desafio("Descriçãozinha, bem zinha mesmo", "Nome da atv", "@drawable/vector.png"));
        desafioslist.add(new Desafio("Descriçãozinha, bem zinha mesmo", "Nome da atv", "@drawable/vector.png"));
        desafioslist.add(new Desafio("Descriçãozinha, bem zinha mesmo", "Nome da atv", "@drawable/vector.png"));
        desafioslist.add(new Desafio("Descriçãozinha, bem zinha mesmo", "Nome da atv", "@drawable/vector.png"));
        desafioslist.add(new Desafio("Descriçãozinha, bem zinha mesmo", "Nome da atv", "@drawable/vector.png"));
        desafioslist.add(new Desafio("Descriçãozinha, bem zinha mesmo", "Nome da atv", "@drawable/vector.png"));
        desafioslist.add(new Desafio("Descriçãozinha, bem zinha mesmo", "Nome da atv", "@drawable/vector.png"));

        desafiosAdapter = new MyRecyclerViewAdapter(desafioslist);

        recyclerViewDesafios.setAdapter(desafiosAdapter);
    }
}
