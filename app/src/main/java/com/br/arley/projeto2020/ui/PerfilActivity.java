package com.br.arley.projeto2020.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        user = currentUser;
        setComponents();
        setComponentsClickListeners();

        edtEmail.setText(user.getEmail());
        edtPassword.setText(user.getPassword());


    }

    private void setComponents() {
        edtEmail = findViewById(R.id.activity_perfil_edt_email);
        edtPassword = findViewById(R.id.activity_perfil_edt_password);
        btnLogOut = findViewById(R.id.activity_perfil_bt_logout);

    }

    void setComponentsClickListeners() {
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLoginStatus(false);
                setCurrentUserPref("");
                Intent intent = new Intent(getApplicationContext(), ListaActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("EXIT", true);
                startActivity(intent);
                finish();
            }
        });
    }

    void setLoginStatus(boolean b) {
        sharedPreferences = getSharedPreferences(getString(R.string.pref_key), Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putBoolean(getString(R.string.pref_login), b);
        editor.apply();
    }

    void setCurrentUserPref(String email){
        sharedPreferences = getSharedPreferences(getString(R.string.pref_key), MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString(getString(R.string.current_email), email);
        editor.apply();
    }
}
