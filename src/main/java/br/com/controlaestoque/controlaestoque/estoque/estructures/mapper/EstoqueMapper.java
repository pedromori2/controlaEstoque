package br.com.controlaestoque.controlaestoque.estoque.estructures.mapper;

import br.com.controlaestoque.controlaestoque.estoque.application.rest.dto.request.EstoqueRequest;
import br.com.controlaestoque.controlaestoque.estoque.application.rest.dto.response.EstoqueResponse;
import br.com.controlaestoque.controlaestoque.estoque.domain.Estoque;
import br.com.controlaestoque.controlaestoque.estoque.domain.ProdutoEstoque;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EstoqueMapper {
    EstoqueResponse toEstoqueResponse(Estoque estoque);
    Estoque toEstoque(EstoqueResponse estoqueResponse);
    List<EstoqueResponse> toEstoqueResponseList(List<Estoque> estoque);
    Estoque requestToEstoque(EstoqueRequest estoqueRequest);

}
