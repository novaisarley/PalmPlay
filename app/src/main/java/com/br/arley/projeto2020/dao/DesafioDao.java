package com.br.arley.projeto2020.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.br.arley.projeto2020.model.Desafio;
import com.br.arley.projeto2020.model.User;

import java.util.List;

@Dao
public interface DesafioDao {

    @Query("SELECT * FROM desafio")
    public List<Desafio> getAllUsers();

    @Insert
    void insertAll(Desafio... desafios);

    @Delete
    void delete(Desafio desafio);
}
