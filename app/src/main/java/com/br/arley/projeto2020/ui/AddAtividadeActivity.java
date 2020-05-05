package com.br.arley.projeto2020.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.br.arley.projeto2020.R;
import com.br.arley.projeto2020.db.AppDataBase;
import com.br.arley.projeto2020.model.Atividade;

public class AddAtividadeActivity extends AppCompatActivity {

    Button btnCriar;
    EditText edtNome, edtDescricao;
    ImageButton ibCapa;
    AppDataBase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_atividade);

        setComponents();
        setComponentsClickListeners();

        db = Room.databaseBuilder(getApplicationContext(), AppDataBase.class, "localStorage").allowMainThreadQueries().build();
    }

    private void setComponents() {
        btnCriar = findViewById(R.id.activity_add_bt_criar);
        edtNome = findViewById(R.id.activity_add_edt_name);
        edtDescricao = findViewById(R.id.activity_add_edt_description);
        ibCapa = findViewById(R.id.activity_add_ib_add_capa);
    }

    void setComponentsClickListeners() {
        btnCriar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nome = edtNome.getText().toString();
                String descricao = edtDescricao.getText().toString();

                if (!nome.isEmpty() && !descricao.isEmpty()){
                    db.atividadeDao().insertAll(new Atividade(nome, descricao, R.drawable.vector));
                    Toast.makeText(AddAtividadeActivity.this, "Atividade Criada", Toast.LENGTH_SHORT);
                    finish();
                }

            }
        });

        ibCapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddAtividadeActivity.this, R.string.not_avaliable, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
