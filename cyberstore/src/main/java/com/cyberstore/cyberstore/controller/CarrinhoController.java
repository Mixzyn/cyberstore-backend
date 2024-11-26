package com.cyberstore.cyberstore.controller;

import com.cyberstore.cyberstore.entity.Produto;
import com.cyberstore.cyberstore.service.CarrinhoService;
import lombok.Getter;
import lombok.Setter;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Getter
@Setter
@RequestMapping("/carrinho")
public class CarrinhoController {

    @Autowired
    private CarrinhoService service;

    @GetMapping("/{id}")
    public ResponseEntity<List<Produto>> listarItens (@PathVariable UUID id) {
        return ResponseEntity.status(200).body(service.listarItens(id));
    }

    @DeleteMapping("/{id}/{id_produto}")
    public ResponseEntity<?> deletarItem(@PathVariable UUID id, @PathVariable UUID produto) {
        service.excluirItem(id, produto);
        return ResponseEntity.status(204).build();
    }
}
