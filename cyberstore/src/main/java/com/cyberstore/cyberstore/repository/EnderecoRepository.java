package com.cyberstore.cyberstore.repository;

import com.cyberstore.cyberstore.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EnderecoRepository extends JpaRepository<Endereco, UUID> {
}
