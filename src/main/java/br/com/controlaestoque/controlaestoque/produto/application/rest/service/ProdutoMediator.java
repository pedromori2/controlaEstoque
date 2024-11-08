package br.com.controlaestoque.controlaestoque.produto.application.rest.service;

import br.com.controlaestoque.controlaestoque.produto.application.rest.dto.request.ProdutoRequest;
import br.com.controlaestoque.controlaestoque.produto.application.rest.dto.response.ProdutoResponse;

import java.util.List;

public interface ProdutoMediator {

    List<ProdutoResponse> getProdutos();
    ProdutoResponse create(ProdutoRequest request);
    ProdutoResponse update(Integer id, ProdutoRequest request);
    void delete(Integer id);

}
