package com.projeto.produtos.dto;

public class CategoriaDTO {
    private Long idCategoria;

    private String nomeCategoria;


    //Construtor

    public CategoriaDTO() {
    }

    public CategoriaDTO(Long idCategoria, String nomeCategoria) {
        this.idCategoria = idCategoria;
        this.nomeCategoria = nomeCategoria;
    }


    //Gets e set
    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }
}
