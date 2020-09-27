package com.br.arley.projeto2020.ui;

import androidx.annotation.NonNull;
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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "Autentication";
    Button btnEntrar;
    TextView tvGoToRegister, tvEsqueceuSenha;
    EditText edtEmail, edtPassword;
    private FirebaseAuth mAuth;
    AppDataBase db;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    public static User currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();

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
        tvEsqueceuSenha = findViewById(R.id.activity_login_tv_forget_password);
    }

    void setComponentsClickListeners(){
        btnEntrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                if(!edtEmail.getText().toString().trim().isEmpty() && !edtPassword.getText().toString().trim().isEmpty()){

                    String email = edtEmail.getText().toString();
                    String password = edtPassword.getText().toString();

                    User user = new User(email, password);

                    //Fazendo Login pelo Room API
                    /*if(autenticateUser(user)){
                        currentUser = user;
                        setCurrentUserPref(user.getEmail());
                        setLoginStatus(true);
                        startActivity(new Intent(LoginActivity.this, ListaActivity.class));
                        finish();
                    }
                    else{
                        Toast.makeText(LoginActivity.this, R.string.email_senha_incorreto, Toast.LENGTH_SHORT).show();
                    }*/

                    authenticateLogin(email, password);


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

        tvEsqueceuSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, R.string.not_avaliable, Toast.LENGTH_SHORT).show();
            }
        });
    }

    void authenticateLogin(String email, String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            setLoginStatus(true);
                            startActivity(new Intent(LoginActivity.this, ListaActivity.class));
                            finish();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, R.string.email_senha_incorreto, Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });
    }

    public boolean autenticateUser(User user){

        String email = user.getEmail();
        String password = user.getPassword();
        List<User> dbUsers = db.userDao().getAllUsers();


        for(int i = 0; i < dbUsers.size(); i++){
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

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }
}
