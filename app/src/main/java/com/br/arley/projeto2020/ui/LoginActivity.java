package com.br.arley.projeto2020.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.br.arley.projeto2020.R;
import com.br.arley.projeto2020.db.AppDataBase;
import com.br.arley.projeto2020.model.User;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "Autentication";
    Button btnEntrar;
    TextView tvGoToRegister;
    EditText edtEmail, edtPassword;
    AppDataBase db;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    public static User currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = Room.databaseBuilder(getApplicationContext(), AppDataBase.class, "localStorage").allowMainThreadQueries().build();

        if (getLoginStatus()){
            currentUser = db.userDao().getUserByEmail(getCurrentUserPref());
            startActivity(new Intent(LoginActivity.this, ListaActivity.class));
            finish();
        }

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

                    String email = edtEmail.getText().toString();
                    String password = edtPassword.getText().toString();

                    User user = new User(email, password);

                    if(autenticateUser(user)){
                        currentUser = user;
                        setCurrentUserPref(user.getEmail());
                        setLoginStatus(true);
                        startActivity(new Intent(LoginActivity.this, ListaActivity.class));
                        finish();
                    }
                    else{
                        Toast.makeText(LoginActivity.this, R.string.email_senha_incorreto, Toast.LENGTH_SHORT).show();
                    }


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

    public boolean autenticateUser(User user){

        String email = user.getEmail();
        String password = user.getPassword();
        List<User> dbUsers = db.userDao().getAllUsers();

        Log.d(TAG, "autenticateUser parametro:" + email + ", " + password);

        for(int i = 0; i < dbUsers.size(); i++){
            Log.d(TAG, "esta na vez de comparar: " + dbUsers.get(i).toString());
            if(dbUsers.get(i).getEmail().equals(email)){
                if (dbUsers.get(i).getPassword().equals(password)){
                    return true;
                }
            }
        }

        return false;
    }

    void setLoginStatus(boolean b) {
        sharedPreferences = getSharedPreferences(getString(R.string.pref_key), Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putBoolean(getString(R.string.pref_login), b);
        editor.apply();
    }

    boolean getLoginStatus(){
        sharedPreferences = getSharedPreferences(getString(R.string.pref_key), Context.MODE_PRIVATE);
        boolean b = sharedPreferences.getBoolean(getString(R.string.pref_login), false);

        return b;
    }

    void setCurrentUserPref(String email){
        sharedPreferences = getSharedPreferences(getString(R.string.pref_key), MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString(getString(R.string.current_email), email);
        editor.apply();
    }

    String getCurrentUserPref(){
        sharedPreferences = getSharedPreferences(getString(R.string.pref_key), Context.MODE_PRIVATE);
        String currentEmail = sharedPreferences.getString(getString(R.string.current_email), "");

        return currentEmail;
    }
}
