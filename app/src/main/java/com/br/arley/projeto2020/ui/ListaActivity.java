package com.br.arley.projeto2020.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.br.arley.projeto2020.R;
import com.br.arley.projeto2020.model.Desafio;
import com.br.arley.projeto2020.model.MyRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListaActivity extends AppCompatActivity {

    RecyclerView recyclerViewDesafios;
    MyRecyclerViewAdapter desafiosAdapter;
    CardView btnPerfil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        setComponentsId();
        setComponentsClickListeners();

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



    void setComponentsId(){
        btnPerfil = findViewById(R.id.activity_lista_cv_perfil);
    }

    void setComponentsClickListeners(){
        btnPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListaActivity.this, PerfilActivity.class));
            }
        });
    }
}
