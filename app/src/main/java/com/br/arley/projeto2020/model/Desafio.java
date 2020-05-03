package com.br.arley.projeto2020.model;

public class Desafio {

    private String Nome;
    private String Descricao;
    private String FotoDUrl;
    private String FotoPUrl;

    public Desafio(String descricao, String nome, String FotoDUrl, String FotoPUrl) {
        this.Descricao = Descricao;
        this.Nome = Nome;
        this.FotoDUrl = FotoDUrl;
        this.FotoPUrl = FotoPUrl;
    }

    public String getFotoPUrl() {
        return FotoPUrl;
    }

    public void setFotoPUrl(String fotoPUrl) {
        FotoPUrl = fotoPUrl;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        this.Nome = Nome;
    }

    public void setDescricao(String descricao) {
        this.Descricao = Descricao;
    }

    public String getDescricao() {
        return Descricao;
    }

    public String getFotoDUrl() {
        return FotoDUrl;
    }

    public void setFotoDUrl(String fotoDUrl) {
        FotoDUrl = fotoDUrl;
    }
}
