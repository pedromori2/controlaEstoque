package br.com.controlaestoque.controlaestoque.estoque.application.rest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EstoqueResponse {

    private Integer id;
    private String descricao;

}
