package br.com.controlaestoque.controlaestoque.produto.estructures.mapper;

import br.com.controlaestoque.controlaestoque.produto.application.rest.dto.request.ProdutoRequest;
import br.com.controlaestoque.controlaestoque.produto.application.rest.dto.response.ProdutoResponse;
import br.com.controlaestoque.controlaestoque.produto.domain.Produto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

    ProdutoResponse toProdutoResponse(Produto produto);
    Produto toProduto(ProdutoResponse produtoResponse);
    List<ProdutoResponse> toProdutoResponseList(List<Produto> produto);
    Produto requestToProduto(ProdutoRequest produtoRequest);

}
