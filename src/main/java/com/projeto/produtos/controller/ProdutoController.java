package com.projeto.produtos.controller;

import com.projeto.produtos.dto.ProdutoDTO;
import com.projeto.produtos.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;


    @GetMapping("/listar")
    public ResponseEntity<?> listarTodos() {
        List<ProdutoDTO> produtoDTOS = produtoService.encontrarTodos();
        return ResponseEntity.status(HttpStatus.OK).body(produtoDTOS);
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable("id") Long id_produto) {
        ProdutoDTO produtoDTO = produtoService.encontrarPorId(id_produto);
        return ResponseEntity.status(HttpStatus.OK).body(produtoDTO);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody ProdutoDTO produto) {
        ProdutoDTO produtoDTO = produtoService.salvar(produto);
        return ResponseEntity.status(HttpStatus.OK).body(produtoDTO);
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> atualizarCategoria(@PathVariable("id") Long id_produto,  @RequestBody ProdutoDTO produto) {
        ProdutoDTO produtoDTO = produtoService.alterar(id_produto, produto);
        return ResponseEntity.status(HttpStatus.OK).body(produtoDTO);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> excluirCategoria(@PathVariable("id") Long id_produto) {
        Boolean produtoDTO = produtoService.excluir(id_produto);
        return ResponseEntity.status(HttpStatus.OK).body("Produto excluido com sucesso!");
    }
}
