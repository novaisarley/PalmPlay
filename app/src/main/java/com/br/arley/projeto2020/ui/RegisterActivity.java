package com.br.arley.projeto2020.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.br.arley.projeto2020.R;
import com.br.arley.projeto2020.db.AppDataBase;
import com.br.arley.projeto2020.model.Atividade;
import com.br.arley.projeto2020.model.User;
import  static com.br.arley.projeto2020.ui.LoginActivity.currentUser;

import java.util.List;

public class RegisterActivity extends AppCompatActivity {
    Button btnSave, btnSeeUsers;
    TextView tvGoToLogin;
    EditText edtEmail, edtPassword, edtConfirmPassword;
    AppDataBase db;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //DEPOIS AJEITO ELE RODAR NA MAIN THREAD
        db = Room.databaseBuilder(getApplicationContext(), AppDataBase.class, "localStorage").
                allowMainThreadQueries().build();
        setComponents();
        setComponentsClickListeners();


        if (!getFirstTime()){
            setFirstTime(true);
            String aviso1 = "Oi, Professor Klinsman. Tudo bem?\n" +
                    "Este é o aplicativo correspondente a atividade de mobile do dia 5 de maio de dois mil e vinte.\n" +
                    "Neste app foi implementada as funções básicas de cadastro, login, vizualização de perfil, cadastro de item de lista e exibição de lista.\n" +
                    "Só foram completados dois desafios: a implementação do Recycler View e do Room.\n Clique no item abaixo para receber mais instruções. Obrigado";

            String aviso2 = "Para criar uma atividade clique no botão de \"mais\" no canto superior esquerdo.\n" +
                    "Como a avaliação requer um cadastro de item e vizualização através de lista, nós implementamos a criação dessas atividades mesmo não sendo o objetivo inicial.\n" +
                    "No objetivo real as atividades serão pequenos jogos que auxiliarão no desenvolvimento do raciocínio lógico de crianças com síndrome de down.\n";

            db.atividadeDao().insertAll(new Atividade("Clique aqui", aviso1, R.drawable.aviso));
            db.atividadeDao().insertAll(new Atividade("Instruções Iniciais", aviso2, R.drawable.aviso));
        }




    }


    private void setComponents() {
        btnSave = findViewById(R.id.activity_register_bt_salvar);
        tvGoToLogin = findViewById(R.id.activity_register_tv_ja_tem_cadastro);
        edtEmail = findViewById(R.id.activity_register_edt_email);
        edtPassword = findViewById(R.id.activity_register_edt_password);
        edtConfirmPassword = findViewById(R.id.activity_register_edt_confirm_password);
        btnSeeUsers = findViewById(R.id.buttonUwsers);
    }

    void setComponentsClickListeners() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!edtEmail.getText().toString().trim().isEmpty() &&
                        !edtPassword.getText().toString().trim().isEmpty() &&
                        !edtConfirmPassword.getText().toString().trim().isEmpty()) {

                    if(edtPassword.getText().toString().equals(edtConfirmPassword.getText().toString())){

                        String email = edtEmail.getText().toString();
                        String password = edtPassword.getText().toString();

                        if (isUserUnique(email)){
                            User user = new User(email, password);

                            db.userDao().insertAll(user);

                            currentUser = user;

                            setCurrentUserPref(currentUser.getEmail());
                            setLoginStatus(true);

                            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                            finish();
                        }
                        else{
                            Toast.makeText(RegisterActivity.this, R.string.usuario_existente_msg, Toast.LENGTH_SHORT).show();
                        }

                    }
                    else{
                        Toast.makeText(RegisterActivity.this, R.string.campos_senha_diferente, Toast.LENGTH_SHORT).show();
                    }


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

        btnSeeUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, UsersActivity.class));
            }
        });
    }

    public boolean isUserUnique(String email){

        List<User> users = db.userDao().getAllUsers();

        for(int i = 0; i < users.size(); i++){
            if(users.get(i).getEmail().equals(email)){
                return false;
            }
        }

        return true;
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

    void setFirstTime(boolean b) {
        sharedPreferences = getSharedPreferences(getString(R.string.pref_key), Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putBoolean(getString(R.string.pref_first_time), b);
        editor.apply();
    }

    boolean getFirstTime(){
        sharedPreferences = getSharedPreferences(getString(R.string.pref_key), Context.MODE_PRIVATE);
        boolean b = sharedPreferences.getBoolean(getString(R.string.pref_first_time), false);

        return b;
    }


}

