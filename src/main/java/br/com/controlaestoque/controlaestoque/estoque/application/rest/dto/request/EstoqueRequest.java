package br.com.controlaestoque.controlaestoque.estoque.application.rest.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstoqueRequest {

    @NotBlank
    @NotNull
    private String descricao;


}
