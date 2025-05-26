package br.com.controlaestoque.controlaestoque.estoque.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "estoque")
@Data
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "descricao")
    private String descricao;

}
