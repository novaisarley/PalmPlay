package com.br.arley.projeto2020.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Desafio {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo
    private String nome;

    @ColumnInfo
    private String descricao;

    @ColumnInfo
    private String fotoDUrl;

    public Desafio(String descricao, String nome, String fotoDUrl) {
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

    public String getFotoDUrl() {
        return fotoDUrl;
    }

    public void setFotoDUrl(String fotoDUrl) {
        fotoDUrl = fotoDUrl;
    }
}
