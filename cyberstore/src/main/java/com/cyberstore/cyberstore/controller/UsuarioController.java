package com.cyberstore.cyberstore.controller;

import com.cyberstore.cyberstore.entity.Usuario;
import com.cyberstore.cyberstore.service.UsuarioService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        return ResponseEntity.status(200).body(service.listarUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Usuario>> mostrarUsuario(@PathVariable UUID id) {
        return ResponseEntity.status(200).body(service.mostrarUsuario(id));
    }

    @PutMapping
    public ResponseEntity<Usuario> editarUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.status(201).body(service.editarUsuario(usuario));
    }

    @DeleteMapping
    public ResponseEntity<?> excluirUsuario(@PathVariable UUID id) {
        service.excluirUsuario(id);
        return ResponseEntity.status(204).build();
    }
}
