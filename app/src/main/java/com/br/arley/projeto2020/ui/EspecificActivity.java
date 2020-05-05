package com.br.arley.projeto2020.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.br.arley.projeto2020.R;

import java.util.Locale;

public class EspecificActivity extends AppCompatActivity {

    ImageButton ibPlaySound;
    Button btnJogar;
    TextView tvNome, tvDescricao;
    ImageView ivCapa;
    TextToSpeech textToSpeech;
    String nome, descricao;
    int imagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_especific);

        setComponents();
        setComponentsClickListeners();
        buildTextToSpeech();
        Intent it = getIntent();
        nome = it.getStringExtra("Nome");
        descricao = it.getStringExtra("Descricao");
        imagem = it.getIntExtra("Imagem", 0);
        fillScreen();

    }

    void setComponents(){
        ibPlaySound = findViewById(R.id.activity_description_ib_play_sound);
        btnJogar = findViewById(R.id.activity_description_bt_jogar);
        tvDescricao = findViewById(R.id.activity_description_tv_descricao);
        tvNome = findViewById(R.id.activity_description_tv_nome_atividade);
        ivCapa = findViewById(R.id.activity_description_iv_image);
    }

    void setComponentsClickListeners(){
        ibPlaySound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String descricao = tvDescricao.getText().toString();
                textToSpeech.speak(descricao, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        btnJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EspecificActivity.this, R.string.not_avaliable, Toast.LENGTH_SHORT).show();
            }
        });
    }

    void fillScreen(){
        tvNome.setText(nome);
        tvDescricao.setText(descricao);
        ivCapa.setImageResource(imagem);
    }

    private void buildTextToSpeech(){
        textToSpeech = new TextToSpeech(EspecificActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS){
                    int result = textToSpeech.setLanguage(new Locale("pt"));

                    /*if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
                        Toast.makeText(ListaActivity.this, "Lingua nao suportada", Toast.LENGTH_SHORT).show();

                    }*/
                }
                else{
                    Toast.makeText(EspecificActivity.this, "inicializacaofalhou", Toast.LENGTH_SHORT).show();

                }
            }
        });
        textToSpeech.setPitch(0.9f);
        textToSpeech.setSpeechRate(0.95f);
    }
}
