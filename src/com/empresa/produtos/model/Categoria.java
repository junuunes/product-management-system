package com.empresa.produtos.model;

public enum Categoria {
    CAMISETAS ("Camisetas"),
    SHORTS ("Shorts"),
    CALCAS ("Calças"),
    SAIAS ("Saias"),
    JAQUETAS ("Jaquetas"),
    ACESSORIOS ("Acessórios");

    private String descricao;

    Categoria (String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
