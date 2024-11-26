package com.cyberstore.cyberstore.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_categoria")
    private UUID categoria_id;

    @Column(name = "nome_categoria")
    private String nome_categoria;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "estoque")
    private Integer estoque;

    @OneToMany(mappedBy = "categoria")
    private List<Produto> produtos;
}
