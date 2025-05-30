package br.com.controlaestoque.controlaestoque.estoque.domain;

import br.com.controlaestoque.controlaestoque.produto.domain.Produto;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "produto_estoque")
@Data
public class ProdutoEstoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "Produto_Id", nullable = false)
    private Produto produto;

    @Column(name = "Quantidade_Disponivel", nullable = false)
    private Integer quantidadeDisponivel;

    @Column(name = "Data_Ultima_Atualizacao", nullable = false)
    private LocalDateTime dataUltimaAtualizacao;

    @ManyToOne
    @JoinColumn(name = "Estoque_Id", nullable = false)
    private ProdutoEstoque estoque;
}
