package com.cyberstore.cyberstore.service;

import com.cyberstore.cyberstore.entity.Produto;
import com.cyberstore.cyberstore.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<Produto> listarProdutos() {
        return repository.findAll();
    }

    public Optional<Produto> mostrarProduto(UUID id) {
        return repository.findById(id);
    }

    public Produto criarProduto(Produto produto) {
        return repository.save(produto);
    }

    public void excluirProduto(UUID id) {
        repository.deleteById(id);
    }
}
