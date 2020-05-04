package com.br.arley.projeto2020.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.br.arley.projeto2020.model.Atividade;

import java.util.List;

@Dao
public interface AtividadeDao {

    @Query("SELECT * FROM atividade")
    public List<Atividade> getAllUsers();

    @Insert
    void insertAll(Atividade... atividades);

    @Delete
    void delete(Atividade atividade);
}
