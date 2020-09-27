package com.br.arley.projeto2020.ui;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

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

import java.util.List;
import java.util.Locale;

/**
 *Arley Novais 3CI
 *Isabella Melo 3CI
 *Rebeca Madi 3CI
 *V0.4
*/

public class ListaActivity extends AppCompatActivity {

    RecyclerView recyclerViewAtividades;
    MyRecyclerViewAdapter atividadesAdapter;
    CardView btnPerfil;
    ImageButton ibAddAtividade;
    AppDataBase db;
    User user;
    public TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_jogos);

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
        buildTextToSpeech();

        recyclerViewAtividades.setLayoutManager(new LinearLayoutManager(this));

        final List<Atividade> atividadesList = db.atividadeDao().getAllAtividades();

        atividadesAdapter = new MyRecyclerViewAdapter(atividadesList);

        recyclerViewAtividades.setAdapter(atividadesAdapter);

        atividadesAdapter.setOnItemClickListener(new MyRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onSoundPlayClick(int position) {
                String descricao = atividadesList.get(position).getDescricao();
                textToSpeech.speak(descricao, TextToSpeech.QUEUE_FLUSH, null);
            }

            @Override
            public void onAtividadeClick(int position) {
                Intent it = new Intent(ListaActivity.this, EspecificActivity.class);
                it.putExtra("Nome", atividadesList.get(position).getNome());
                it.putExtra("Descricao", atividadesList.get(position).getDescricao());
                it.putExtra("Imagem", atividadesList.get(position).getFotoDUrl());
                startActivity(it);
            }
        });
    }

    private void buildTextToSpeech(){
        textToSpeech = new TextToSpeech(ListaActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS){
                    int result = textToSpeech.setLanguage(new Locale ("pt"));
                    /*if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
                        Toast.makeText(ListaActivity.this, "Lingua nao suportada", Toast.LENGTH_SHORT).show();

                    }*/
                }
                else{
                    Toast.makeText(ListaActivity.this, "inicializacaofalhou", Toast.LENGTH_SHORT).show();

                }
            }
        });
        textToSpeech.setPitch(0.9f);
        textToSpeech.setSpeechRate(0.95f);
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (textToSpeech != null){
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
    }
}
