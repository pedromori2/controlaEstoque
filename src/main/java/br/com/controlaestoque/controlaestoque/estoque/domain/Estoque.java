package br.com.controlaestoque.controlaestoque.estoque.domain;

import br.com.controlaestoque.controlaestoque.produto.domain.Produto;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "estoque")
@Data
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "Produto_ID", nullable = false)
    private Produto produto;

    @Column(name = "Quantidade_Disponivel", nullable = false)
    private Integer quantidadeDisponivel;

    @Column(name = "Data_Ultima_Atualizacao", nullable = false)
    private LocalDateTime dataUltimaAtualizacao;

}
