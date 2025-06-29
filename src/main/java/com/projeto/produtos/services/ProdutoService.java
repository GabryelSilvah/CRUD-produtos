package com.projeto.produtos.services;

import com.projeto.produtos.dto.ProdutoDTO;
import com.projeto.produtos.exceptions.RegistroExistsException;
import com.projeto.produtos.exceptions.RegistroNotFoundException;
import com.projeto.produtos.model.Categoria;
import com.projeto.produtos.model.Produto;
import com.projeto.produtos.repository.CategoriaRepository;
import com.projeto.produtos.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutosRepository produtosRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<ProdutoDTO> encontrarTodos() {

        //Buscando dados
        List<Produto> listaProdutos = produtosRepository.findAll();


        //Convertendo para DTO
        List<ProdutoDTO> listaProdutosDTO = new ArrayList<>();

        for (int i = 0; i < listaProdutos.size(); i++) {
            listaProdutosDTO.add(
                    new ProdutoDTO(
                            listaProdutos.get(i).getIdProduto(),
                            listaProdutos.get(i).getNomeProduto(),
                            listaProdutos.get(i).getPrecoProduto(),
                            listaProdutos.get(i).getCategoriaId().getIdCategoria()
                    )
            );
        }

        return listaProdutosDTO;
    }

    public ProdutoDTO encontrarPorId(Long id_produto) {

        Optional<Produto> produtoEncontrado = produtosRepository.findById(id_produto);
        if (produtoEncontrado.isEmpty()) {
            throw new RegistroNotFoundException("(" + id_produto + ") não foi encontrado nenhem produto com esse id");
        }

        return new ProdutoDTO(
                produtoEncontrado.get().getIdProduto(),
                produtoEncontrado.get().getNomeProduto(),
                produtoEncontrado.get().getPrecoProduto(),
                produtoEncontrado.get().getCategoriaId().getIdCategoria()
        );
    }


    public ProdutoDTO salvar(ProdutoDTO produtoRecebido) {

        //Validando se já existe produto com esse nome
        Optional<Produto> produtoEncontrado = produtosRepository.findByNomeProduto(produtoRecebido.getNomeProduto());
        if (produtoEncontrado.isPresent()) {
            throw new RegistroExistsException("Já existe um produto com esse nome");
        }

        //Validando se categoria informada para o produto existe
        Optional<Categoria> categoriaEncontrada = categoriaRepository.findById(produtoRecebido.getCategoriaId());
        if (categoriaEncontrada.isEmpty()) {
            throw new RegistroNotFoundException("Categoria informada para produto com id (" + produtoRecebido.getCategoriaId() + ") não existe");
        }

        //Salvando produto
        Produto produtoCadastrado = produtosRepository.save(new Produto(
                        produtoRecebido.getIdProduto(),
                        produtoRecebido.getNomeProduto(),
                        produtoRecebido.getPrecoProduto(),
                        new Categoria(produtoRecebido.getCategoriaId())
                )
        );


        return new ProdutoDTO(
                produtoCadastrado.getIdProduto(),
                produtoCadastrado.getNomeProduto(),
                produtoCadastrado.getPrecoProduto(),
                produtoCadastrado.getCategoriaId().getIdCategoria()
        );
    }

    public ProdutoDTO alterar(Long id_produto, ProdutoDTO produtoRecebido) {

        //Validando se  o produto informado existe
        Optional<Produto> produtoEncontrado = produtosRepository.findById(id_produto);
        if (produtoEncontrado.isEmpty()) {
            throw new RegistroNotFoundException("Produto informado com id (" + id_produto + ") não existe");
        }

        //Validando se já existe produto com esse nome e se esse produto existente não é o proprio a ser a alterado
        Optional<Produto> produtoEncontradaByName = produtosRepository.findByNomeProduto(produtoRecebido.getNomeProduto());
        if (produtoEncontradaByName.isPresent() && !(produtoEncontradaByName.get().getIdProduto().equals(id_produto))) {
            throw new RegistroExistsException("Já existe um produto com esse nome");
        }

        //Validando se categoria informada para o produto existe
        Optional<Categoria> categoriaEncontrada = categoriaRepository.findById(produtoRecebido.getCategoriaId());
        if (categoriaEncontrada.isEmpty()) {
            throw new RegistroNotFoundException("Categoria informada para produto com id (" + produtoRecebido.getCategoriaId() + ") não existe");
        }


        //Salvando alteração
        produtoEncontrado.get().setNomeProduto(produtoRecebido.getNomeProduto());
        produtoEncontrado.get().setPrecoProduto(produtoRecebido.getPrecoProduto());
        produtoEncontrado.get().setCategoriaId(new Categoria(produtoRecebido.getCategoriaId()));
        Produto produtoAlterado = produtosRepository.save(produtoEncontrado.get());


        return new ProdutoDTO(
                produtoAlterado.getIdProduto(),
                produtoAlterado.getNomeProduto(),
                produtoAlterado.getPrecoProduto(),
                produtoAlterado.getCategoriaId().getIdCategoria()
        );
    }

    public Boolean excluir(Long id_produto) {
        //Validando se o produto informado existe
        Optional<Produto> produtoEncontrado = produtosRepository.findById(id_produto);
        if (produtoEncontrado.isEmpty()) {
            throw new RegistroNotFoundException("Categoria informada com id (" + id_produto + ") não existe");
        }

        produtosRepository.deleteById(id_produto);
        return true;
    }
}
