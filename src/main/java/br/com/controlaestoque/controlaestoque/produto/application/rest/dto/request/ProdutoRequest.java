package br.com.controlaestoque.controlaestoque.produto.application.rest.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequest {

    @NotBlank
    @NotNull
    private String nome;
    @NotBlank
    @NotNull
    private String descricao;
    @NotBlank
    @NotNull
    private BigDecimal preco;

}
