package com.cyberstore.cyberstore.repository;

import com.cyberstore.cyberstore.entity.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CarrinhoRepository extends JpaRepository<Carrinho, UUID> {
}
