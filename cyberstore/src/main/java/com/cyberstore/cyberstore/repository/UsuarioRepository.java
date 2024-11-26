package com.cyberstore.cyberstore.repository;

import com.cyberstore.cyberstore.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
}
