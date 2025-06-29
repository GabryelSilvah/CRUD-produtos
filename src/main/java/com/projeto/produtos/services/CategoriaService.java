package com.projeto.produtos.services;

import com.projeto.produtos.dto.CategoriaDTO;
import com.projeto.produtos.exceptions.RegistroExistsException;
import com.projeto.produtos.exceptions.RegistroNotFoundException;
import com.projeto.produtos.model.Categoria;
import com.projeto.produtos.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;


    public List<CategoriaDTO> encontrarTodos() {

        //Buscando dados
        List<Categoria> listaCategorias = categoriaRepository.findAll();


        //Convertendo para DTO
        List<CategoriaDTO> listaCategoriasDTO = new ArrayList<>();

        for (int i = 0; i < listaCategorias.size(); i++) {
            listaCategoriasDTO.add(
                    new CategoriaDTO(listaCategorias.get(i).getIdCategoria(), listaCategorias.get(i).getNomeCategoria())
            );
        }

        return listaCategoriasDTO;
    }

    public CategoriaDTO encontrarPorId(Long id_categoria) {

        Optional<Categoria> categoriaEncontrada = categoriaRepository.findById(id_categoria);
        if (categoriaEncontrada.isEmpty()) {
            throw new RegistroNotFoundException("(" + id_categoria + ") não foi encontrado nenhema categoria com esse id");
        }

        return new CategoriaDTO(categoriaEncontrada.get().getIdCategoria(), categoriaEncontrada.get().getNomeCategoria());
    }


    public CategoriaDTO salvar(CategoriaDTO categoriaRecebida) {

        //Validando se já existe categoria com esse nome
        Optional<Categoria> categoriaEncontrada = categoriaRepository.findByNomeCategoria(categoriaRecebida.getNomeCategoria());
        if (categoriaEncontrada.isPresent()) {
            throw new RegistroExistsException("Já existe uma categoria com esse nome");
        }

        Categoria categoriaCadastrada = categoriaRepository.save(new Categoria(categoriaRecebida.getIdCategoria(), categoriaRecebida.getNomeCategoria()));


        return new CategoriaDTO(categoriaCadastrada.getIdCategoria(), categoriaCadastrada.getNomeCategoria());
    }

    public CategoriaDTO alterar(Long id_categoria, CategoriaDTO categoriaRecebida) {

        //Validando se a categoria informada existe
        Optional<Categoria> categoriaEncontrada = categoriaRepository.findById(id_categoria);
        if (categoriaEncontrada.isEmpty()) {
            throw new RegistroNotFoundException("Categoria informada com id (" + id_categoria + ") não existe");
        }

        //Validando se já existe categoria com esse nome e se essa categoria existente não é a propria a ser a alterada
        Optional<Categoria> categoriaEncontradaByName = categoriaRepository.findByNomeCategoria(categoriaRecebida.getNomeCategoria());
        if (categoriaEncontradaByName.isPresent() && !(categoriaEncontradaByName.get().getIdCategoria().equals(id_categoria))) {
            throw new RegistroExistsException("Já existe uma categoria com esse nome");
        }

        //Salvando alteração
        categoriaEncontrada.get().setNomeCategoria(categoriaRecebida.getNomeCategoria());
        Categoria categoriaAlterada = categoriaRepository.save(categoriaEncontrada.get());

        return new CategoriaDTO(categoriaAlterada.getIdCategoria(), categoriaAlterada.getNomeCategoria());
    }

    public Boolean excluir(Long id_categoria) {
        //Validando se a categoria informada existe
        Optional<Categoria> categoriaEncontrada = categoriaRepository.findById(id_categoria);
        if (categoriaEncontrada.isEmpty()) {
            throw new RegistroNotFoundException("Categoria informada com id (" + id_categoria + ") não existe");
        }

        categoriaRepository.deleteById(id_categoria);
        return true;
    }
}
