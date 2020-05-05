package com.br.arley.projeto2020.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Atividade {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo
    private String nome;

    @ColumnInfo
    private String descricao;

    @ColumnInfo
    private int fotoDUrl;

    public Atividade(String nome, String descricao, int fotoDUrl) {
        this.descricao = descricao;
        this.nome = nome;
        this.fotoDUrl = fotoDUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) { this.nome = nome;}

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getFotoDUrl() {
        return fotoDUrl;
    }

    public void setFotoDUrl(int fotoDUrl) {
        fotoDUrl = fotoDUrl;
    }
}
