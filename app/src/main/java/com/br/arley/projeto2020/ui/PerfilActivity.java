package com.br.arley.projeto2020.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.br.arley.projeto2020.R;
import com.br.arley.projeto2020.model.User;

import static com.br.arley.projeto2020.ui.LoginActivity.currentUser;

public class PerfilActivity extends AppCompatActivity {

    Button  btnLogOut;
    User user;
    EditText edtEmail, edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        user = currentUser;
        System.out.println("ADOLETA"+user);
        System.out.println("ADOLETA"+currentUser);
        setComponents();

        edtEmail.setText(user.getEmail());
        edtPassword.setText(user.getPassword());


    }

    private void setComponents() {
        edtEmail = findViewById(R.id.activity_perfil_edt_email);
        edtPassword = findViewById(R.id.activity_perfil_edt_password);

    }

    void setComponentsClickListeners() {

    }
}
