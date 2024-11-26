package com.cyberstore.cyberstore.service;

import com.cyberstore.cyberstore.entity.Endereco;
import com.cyberstore.cyberstore.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    public List<Endereco> listarEndereco() {
        return repository.findAll();
    }

    public Optional<Endereco> mostrarEndereco(UUID id) {
        return repository.findById(id);
    }

    public Endereco criarEndereco(Endereco end) {
        return repository.save(end);
    }

    public void excluirEndereco(UUID id) {
        repository.deleteById(id);
    }
}
