package com.cyberstore.cyberstore.controller;

import com.cyberstore.cyberstore.entity.Produto;
import com.cyberstore.cyberstore.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public ResponseEntity<List<Produto>> listarProduto() {
        return ResponseEntity.status(200).body(service.listarProdutos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Produto>> mostrarProduto(@PathVariable UUID id) {
        return ResponseEntity.status(200).body(service.mostrarProduto(id));
    }

    @PostMapping
    public ResponseEntity<Produto> criarProduto(@RequestBody Produto produto) {
        return ResponseEntity.status(201).body(service.criarProduto(produto));
    }

    @PutMapping
    public ResponseEntity<Produto> alterarProduto(@RequestBody Produto produto) {
        return ResponseEntity.status(201).body(service.criarProduto(produto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirProduto(@PathVariable UUID id) {
        service.excluirProduto(id);
        return ResponseEntity.status(204).build();
    }
}
