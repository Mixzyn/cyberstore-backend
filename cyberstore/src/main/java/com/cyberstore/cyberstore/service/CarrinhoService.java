package com.cyberstore.cyberstore.service;

import com.cyberstore.cyberstore.entity.Carrinho;
import com.cyberstore.cyberstore.entity.Produto;
import com.cyberstore.cyberstore.entity.Usuario;
import com.cyberstore.cyberstore.repository.CarrinhoRepository;
import com.cyberstore.cyberstore.repository.ProdutoRepository;
import com.cyberstore.cyberstore.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository repository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listarItens(UUID id) {
        Optional<Carrinho> carrinho = repository.findById(id);
        return carrinho.get().getItens();
    }

    public void excluirItem(UUID id, UUID id_produto) {
        Optional<Carrinho> carrinho = repository.findById(id);
        Optional<Produto> produto = produtoRepository.findById(id_produto);
        carrinho.get().getItens().remove(produto);
    }
}
