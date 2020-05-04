package com.br.arley.projeto2020.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.br.arley.projeto2020.R;
import com.br.arley.projeto2020.db.AppDataBase;
import com.br.arley.projeto2020.model.Atividade;
import com.br.arley.projeto2020.adapter.MyRecyclerViewAdapter;
import com.br.arley.projeto2020.model.User;

import static com.br.arley.projeto2020.ui.LoginActivity.currentUser;

import java.util.ArrayList;
import java.util.List;

public class ListaActivity extends AppCompatActivity {

    RecyclerView recyclerViewAtividades;
    MyRecyclerViewAdapter atividadesAdapter;
    CardView btnPerfil;
    ImageButton ibAddAtividade;
    AppDataBase db;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        db = Room.databaseBuilder(getApplicationContext(), AppDataBase.class, "localStorage").allowMainThreadQueries().build();

        user = currentUser;

        setComponentsId();
        setComponentsClickListeners();

        builAtividadesRecyclerView();

    }


    void setComponentsId() {
        btnPerfil = findViewById(R.id.activity_lista_cv_perfil);
        ibAddAtividade = findViewById(R.id.activity_lista_ib_add_atividade);
        recyclerViewAtividades = findViewById(R.id.activity_lista_rv_atividade);
    }

    void setComponentsClickListeners() {
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

    void builAtividadesRecyclerView() {
        recyclerViewAtividades.setLayoutManager(new LinearLayoutManager(this));

        List<Atividade> atividadesList = db.atividadeDao().getAllAtividades();

        atividadesAdapter = new MyRecyclerViewAdapter(atividadesList);

        recyclerViewAtividades.setAdapter(atividadesAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (getIntent().getBooleanExtra("EXIT", false)) {
            startActivity(new Intent(ListaActivity.this, LoginActivity.class));
            finish();
        }
        builAtividadesRecyclerView();
    }
}
