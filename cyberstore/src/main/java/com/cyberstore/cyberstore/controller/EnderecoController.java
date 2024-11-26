package com.cyberstore.cyberstore.controller;

import com.cyberstore.cyberstore.entity.Endereco;
import com.cyberstore.cyberstore.entity.Produto;
import com.cyberstore.cyberstore.repository.EnderecoRepository;
import com.cyberstore.cyberstore.service.EnderecoService;
import com.cyberstore.cyberstore.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/{id}/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService service;

    @GetMapping
    public ResponseEntity<List<Endereco>> listarEndereco() {
        return ResponseEntity.status(200).body(service.listarEndereco());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Endereco>> mostrarEndereco(@PathVariable UUID id) {
        return ResponseEntity.status(200).body(service.mostrarEndereco(id));
    }

    @PostMapping
    public ResponseEntity<Endereco> criarEndereco(@RequestBody Endereco endereco) {
        return ResponseEntity.status(201).body(service.criarEndereco(endereco));
    }

    @PutMapping
    public ResponseEntity<Endereco> editarEndereco(@RequestBody Endereco endereco) {
        return ResponseEntity.status(201).body(service.criarEndereco(endereco));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirEndereco(@PathVariable UUID id) {
        service.excluirEndereco(id);
        return ResponseEntity.status(204).build();
    }
}
