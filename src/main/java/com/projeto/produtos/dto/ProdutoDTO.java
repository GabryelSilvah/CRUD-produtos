package com.projeto.produtos.dto;

public class ProdutoDTO {

    private Long idProduto;

    private String nomeProduto;

    private double precoProduto;

    private Long categoriaId;

    //Construtor


    public ProdutoDTO() {
    }

    public ProdutoDTO(Long idProduto, String nomeProduto, double precoProduto, Long categoriaId) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.precoProduto = precoProduto;
        this.categoriaId = categoriaId;
    }


    //Gets e sets

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(double precoProduto) {
        this.precoProduto = precoProduto;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }
}
