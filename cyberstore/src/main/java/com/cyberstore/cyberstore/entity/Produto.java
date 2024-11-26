package com.cyberstore.cyberstore.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_produto")
    private UUID idProduto;

    @Column(name = "nome_produto")
    private String nome_produto;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "preco_produto")
    private Float preco_produto;

    @Column(name = "imagem_produto")
    private String imagem_produto; // Não é uma String imbecil

    @ManyToOne
    @JoinColumn(name = "categoria")
    private Categoria categoria;

    @OneToOne
    @JoinColumn(name = "carrinho")
    private Carrinho carrinho;
}
