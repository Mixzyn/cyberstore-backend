package com.cyberstore.cyberstore.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_usuario")
    private UUID id_usuario;

    @Column(name = "nome_usuario")
    private String nome_usuario;

    @Column(name = "email_usuario")
    private String email_usuario;

    @Column(name = "senha_usuario")
    private String senha_usuario;

    @OneToMany(mappedBy = "usuario_id")
    private List<Endereco> endereco;

    @Column(name = "telefone_usuario")
    private String telefone_usuario;

    @Column(name = "usuario_ativo")
    private Boolean usuario_ativo;

    @OneToOne
    @JoinColumn(name = "carrinho")
    private Carrinho carrinho;
}
