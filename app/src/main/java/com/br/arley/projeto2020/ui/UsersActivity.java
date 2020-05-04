package com.br.arley.projeto2020.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.TextView;

import com.br.arley.projeto2020.R;
import com.br.arley.projeto2020.db.AppDataBase;
import com.br.arley.projeto2020.model.User;

import java.util.List;

public class UsersActivity extends AppCompatActivity {

    AppDataBase db;
    List<User> users;
    TextView listaDeUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        listaDeUsers = findViewById(R.id.tv_user_list);

        db = Room.databaseBuilder(getApplicationContext(), AppDataBase.class, "localStorage")
                .allowMainThreadQueries().build();

        users = db.userDao().getAllUsers();

        listaDeUsers.setText(users.toString());
        

    }
}
