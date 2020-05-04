package com.br.arley.projeto2020.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.br.arley.projeto2020.dao.AtividadeDao;
import com.br.arley.projeto2020.dao.UserDao;
import com.br.arley.projeto2020.model.Atividade;
import com.br.arley.projeto2020.model.User;

@Database(entities = {User.class, Atividade.class},  version = 2)
public abstract class AppDataBase extends RoomDatabase {

    public abstract UserDao userDao();
    public abstract AtividadeDao atividadeDao();
}
