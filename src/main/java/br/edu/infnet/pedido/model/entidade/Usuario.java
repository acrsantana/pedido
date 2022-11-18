package br.edu.infnet.pedido.model.entidade;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter @Setter @NoArgsConstructor @ToString
public class Usuario {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private Timestamp dataCriacao;
}
