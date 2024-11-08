package br.com.controlaestoque.controlaestoque.produto.application.rest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoResponse {

    private Integer id;
    private String nome;
    private String descricao;
    private BigDecimal preco;

}
