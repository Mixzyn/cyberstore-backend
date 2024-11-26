package com.cyberstore.cyberstore.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "carrinho")
public class Carrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_carrinho")
    private UUID id_carinho;

    @OneToOne
    @JoinColumn(name = "usuario")
    private UUID usuario_id;

    @OneToMany(mappedBy = "carrinho")
    private List<Produto> itens;

    @Column(name = "valor_total")
    private Float valor_total;

    public void excluirItem(Produto produto) {
        itens.remove(produto);
    }
}
