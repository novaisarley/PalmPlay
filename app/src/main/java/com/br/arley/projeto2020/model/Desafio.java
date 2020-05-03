package com.br.arley.projeto2020.model;

public class Desafio {

    private String nome;
    private String descricao;
    private String fotoDUrl;

    public Desafio(String descricao, String nome, String fotoDUrl) {
        this.descricao = descricao;
        this.nome = nome;
        this.fotoDUrl = fotoDUrl;
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
