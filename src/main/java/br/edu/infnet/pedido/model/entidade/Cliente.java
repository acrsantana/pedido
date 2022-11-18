package br.edu.infnet.pedido.model.entidade;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class Cliente {
    private Long codigo;
    private String nome;

    public Cliente(String nome, Long codigo) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public Cliente(String nome) {
        this.nome = nome;
    }
}
