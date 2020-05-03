package com.br.arley.projeto2020;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    Button btnSave;
    TextView tvGoToLogin;
    EditText edtEmail, edtPassword, edtConfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        setComponents();
        setComponentsClickListeners();

    }


    private void setComponents() {
        btnSave = findViewById(R.id.activity_register_bt_salvar);
        tvGoToLogin = findViewById(R.id.activity_register_tv_ja_tem_cadastro);
        edtEmail = findViewById(R.id.activity_register_edt_email);
        edtPassword = findViewById(R.id.activity_register_edt_password);
        edtConfirmPassword = findViewById(R.id.activity_register_edt_confirm_password);
    }

    void setComponentsClickListeners() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!edtEmail.getText().toString().trim().isEmpty() &&
                        !edtPassword.getText().toString().trim().isEmpty() &&
                        !edtConfirmPassword.getText().toString().trim().isEmpty()) {
                    startActivity(new Intent(RegisterActivity.this, ListaActivity.class));
                    finish();
                }
                else{
                    Toast.makeText(RegisterActivity.this, R.string.preencha_todos_campos, Toast.LENGTH_SHORT).show();
                }

            }
        });

        tvGoToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                finish();
            }
        });
    }
}

