package com.br.arley.projeto2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    Button btnEntrar;
    TextView tvGoToRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setComponents();

        btnEntrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
               startActivity(new Intent(LoginActivity.this, ListaActivity.class));
               finish();
            }
        });
        tvGoToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

        }


    private void setComponents() {

        btnEntrar = findViewById(R.id.activity_login_bt_entrar);
        tvGoToRegister = findViewById(R.id.activity_login_tv_cadastre_se);
    }
}
