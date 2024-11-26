package com.cyberstore.cyberstore.repository;

import com.cyberstore.cyberstore.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<Produto, UUID> {
}
