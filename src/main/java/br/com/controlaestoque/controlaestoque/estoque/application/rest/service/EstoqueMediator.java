package br.com.controlaestoque.controlaestoque.estoque.application.rest.service;

import br.com.controlaestoque.controlaestoque.estoque.application.rest.dto.request.EstoqueRequest;
import br.com.controlaestoque.controlaestoque.estoque.application.rest.dto.response.EstoqueResponse;

import java.util.List;

public interface EstoqueMediator {

    List<EstoqueResponse> getEstoques();
    EstoqueResponse create(EstoqueRequest estoqueRequest);
    EstoqueResponse update(Integer id, EstoqueRequest request);
    void delete(Integer id);


}
