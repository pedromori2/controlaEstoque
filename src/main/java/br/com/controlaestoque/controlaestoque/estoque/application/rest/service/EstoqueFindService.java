package br.com.controlaestoque.controlaestoque.estoque.application.rest.service;

import br.com.controlaestoque.controlaestoque.estoque.application.rest.dto.response.EstoqueResponse;
import br.com.controlaestoque.controlaestoque.estoque.domain.Estoque;
import br.com.controlaestoque.controlaestoque.estoque.domain.repository.EstoqueRepository;
import br.com.controlaestoque.controlaestoque.estoque.estructures.mapper.EstoqueMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class EstoqueFindService {

    private final EstoqueRepository repository;
    private final EstoqueMapper mapper;

    public List<EstoqueResponse> getEstoques(){
        List<Estoque> estoques = repository.findAll();

        return estoques.stream().map(mapper::toEstoqueResponse).collect(toList());

    }

}
