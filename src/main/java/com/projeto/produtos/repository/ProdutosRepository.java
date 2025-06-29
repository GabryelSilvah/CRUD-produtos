package com.projeto.produtos.repository;

import com.projeto.produtos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutosRepository extends JpaRepository<Produto, Long> {

    Optional<Produto> findByNomeProduto(String nomeProduto);
}
