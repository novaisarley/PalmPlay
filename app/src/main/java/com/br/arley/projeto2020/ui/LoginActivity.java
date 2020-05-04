package com.br.arley.projeto2020.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.br.arley.projeto2020.R;

public class LoginActivity extends AppCompatActivity {
    Button btnEntrar;
    TextView tvGoToRegister;
    EditText edtEmail, edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setComponents();
        setComponentsClickListeners();


        }


    private void setComponents() {

        btnEntrar = findViewById(R.id.activity_login_bt_entrar);
        tvGoToRegister = findViewById(R.id.activity_login_tv_cadastre_se);
        edtEmail = findViewById(R.id.activity_login_edt_email);
        edtPassword = findViewById(R.id.activity_login_edt_password);
    }

    void setComponentsClickListeners(){
        btnEntrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                if(!edtEmail.getText().toString().trim().isEmpty() && !edtPassword.getText().toString().trim().isEmpty()){
                    startActivity(new Intent(LoginActivity.this, ListaActivity.class));
                    finish();
                }
                else{
                    Toast.makeText(LoginActivity.this, R.string.preencha_todos_campos, Toast.LENGTH_SHORT).show();
                }

            }
        });
        tvGoToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                finish();
            }
        });
    }
}
