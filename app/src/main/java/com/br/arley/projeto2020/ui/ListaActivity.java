package com.br.arley.projeto2020.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.br.arley.projeto2020.R;
import com.br.arley.projeto2020.model.Atividade;
import com.br.arley.projeto2020.adapter.MyRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListaActivity extends AppCompatActivity {

    RecyclerView recyclerViewAtividades;
    MyRecyclerViewAdapter atividadesAdapter;
    CardView btnPerfil;
    ImageButton ibAddAtividade;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        setComponentsId();
        setComponentsClickListeners();

        recyclerViewAtividades =  findViewById(R.id.activity_lista_rv_atividade);
        recyclerViewAtividades.setLayoutManager(new LinearLayoutManager(this));

        List<Atividade> atividadesList = new ArrayList<Atividade>();
        atividadesList.add(new Atividade("Descriçãozinha, bem zinha mesmo", "Nome da atv", "@drawable/vector.png"));
        atividadesList.add(new Atividade("Descriçãozinha, bem zinha mesmo", "Nome da atv", "@drawable/vector.png"));
        atividadesList.add(new Atividade("Descriçãozinha, bem zinha mesmo", "Nome da atv", "@drawable/vector.png"));
        atividadesList.add(new Atividade("Descriçãozinha, bem zinha mesmo", "Nome da atv", "@drawable/vector.png"));
        atividadesList.add(new Atividade("Descriçãozinha, bem zinha mesmo", "Nome da atv", "@drawable/vector.png"));
        atividadesList.add(new Atividade("Descriçãozinha, bem zinha mesmo", "Nome da atv", "@drawable/vector.png"));
        atividadesList.add(new Atividade("Descriçãozinha, bem zinha mesmo", "Nome da atv", "@drawable/vector.png"));
        atividadesList.add(new Atividade("Descriçãozinha, bem zinha mesmo", "Nome da atv", "@drawable/vector.png"));
        atividadesList.add(new Atividade("Descriçãozinha, bem zinha mesmo", "Nome da atv", "@drawable/vector.png"));
        atividadesList.add(new Atividade("Descriçãozinha, bem zinha mesmo", "Nome da atv", "@drawable/vector.png"));

        atividadesAdapter = new MyRecyclerViewAdapter(atividadesList);

        recyclerViewAtividades.setAdapter(atividadesAdapter);
    }



    void setComponentsId(){
        btnPerfil = findViewById(R.id.activity_lista_cv_perfil);
        ibAddAtividade = findViewById(R.id.activity_lista_ib_add_atividade);
    }

    void setComponentsClickListeners(){
        btnPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListaActivity.this, PerfilActivity.class));
            }
        });

        ibAddAtividade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListaActivity.this, AddAtividadeActivity.class));
            }
        });
    }
}
