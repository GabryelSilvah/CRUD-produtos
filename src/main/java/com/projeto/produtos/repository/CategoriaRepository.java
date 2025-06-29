package com.projeto.produtos.repository;

import com.projeto.produtos.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    Optional<Categoria> findByNomeCategoria(String nomeProduto);
}
