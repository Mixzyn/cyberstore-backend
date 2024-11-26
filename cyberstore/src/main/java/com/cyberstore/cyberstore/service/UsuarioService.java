package com.cyberstore.cyberstore.service;

import com.cyberstore.cyberstore.entity.Usuario;
import com.cyberstore.cyberstore.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> listarUsuarios() {
        return repository.findAll();
    }

    public Optional<Usuario> mostrarUsuario(UUID id) {
        return repository.findById(id);
    }

    public Usuario editarUsuario(Usuario usuario) {
        return repository.save(usuario);
    }

    public void excluirUsuario (UUID id) {
        repository.deleteById(id);
    }
}
