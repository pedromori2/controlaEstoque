package br.com.controlaestoque.controlaestoque.produto.application.rest.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequest {

    private String nome;
    private String descricao;
    private BigDecimal preco;

}
