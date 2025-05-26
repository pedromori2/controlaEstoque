package br.com.controlaestoque.controlaestoque.estoque.application.rest.service;

import br.com.controlaestoque.controlaestoque.estoque.application.rest.dto.request.EstoqueRequest;
import br.com.controlaestoque.controlaestoque.estoque.application.rest.dto.response.EstoqueResponse;
import br.com.controlaestoque.controlaestoque.estoque.application.rest.validation.EstoqueValidation;
import br.com.controlaestoque.controlaestoque.estoque.domain.Estoque;
import br.com.controlaestoque.controlaestoque.estoque.domain.repository.EstoqueRepository;
import br.com.controlaestoque.controlaestoque.estoque.estructures.mapper.EstoqueMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EstoqueCreateService {

    private final EstoqueRepository repository;
    private final EstoqueMapper mapper;
    private final EstoqueValidation validation;

    public EstoqueResponse create(EstoqueRequest estoqueRequest) {
        Estoque estoque = mapper.requestToEstoque(estoqueRequest);
        validation.validaEstoque(estoque.getDescricao());
        repository.save(estoque);

        return mapper.toEstoqueResponse(estoque);

    }

}
