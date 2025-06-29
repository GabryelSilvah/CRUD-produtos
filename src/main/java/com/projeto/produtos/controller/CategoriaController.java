package com.projeto.produtos.controller;

import com.projeto.produtos.dto.CategoriaDTO;
import com.projeto.produtos.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;


    @GetMapping("/listar")
    public ResponseEntity<?> listarTodos() {
        List<CategoriaDTO> categoriaDTO = categoriaService.encontrarTodos();
        return ResponseEntity.status(HttpStatus.OK).body(categoriaDTO);
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable("id") Long id_categoria) {
        CategoriaDTO categoriaDTO = categoriaService.encontrarPorId(id_categoria);
        return ResponseEntity.status(HttpStatus.OK).body(categoriaDTO);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody CategoriaDTO categoria) {
        CategoriaDTO categoriaDTO = categoriaService.salvar(categoria);
        return ResponseEntity.status(HttpStatus.OK).body(categoriaDTO);
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> atualizarCategoria(@PathVariable("id") Long id_categoria,  @RequestBody CategoriaDTO categoria) {
        CategoriaDTO categoriaDTO = categoriaService.alterar(id_categoria, categoria);
        return ResponseEntity.status(HttpStatus.OK).body(categoriaDTO);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> excluirCategoria(@PathVariable("id") Long id_categoria) {
        Boolean categoriaDTO = categoriaService.excluir(id_categoria);
        return ResponseEntity.status(HttpStatus.OK).body("Categoria excluido com sucesso!");
    }
}
