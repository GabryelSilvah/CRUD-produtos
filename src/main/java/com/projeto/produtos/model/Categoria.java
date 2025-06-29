package com.projeto.produtos.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoria;

    @Column(name = "nomeCategoria")
    private String nomeCategoria;

    @OneToMany(mappedBy = "categoriaId", fetch = FetchType.LAZY)
    private List<Produto> listaProdutos;

    //Construtor
    public Categoria() {
    }

    public Categoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Categoria(Long idCategoria, String nomeCategoria) {
        this.idCategoria = idCategoria;
        this.nomeCategoria = nomeCategoria;
    }


    //Gets e sets
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
