package br.com.controlaestoque.controlaestoque.estoque.application.rest.validation;

import br.com.controlaestoque.controlaestoque.estoque.domain.repository.EstoqueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EstoqueValidation {

    private final EstoqueRepository repository;

    public void validaEstoque (String descricao){
        if (repository.existsByDescricao(descricao)){
            throw new RuntimeException("Estoque já cadastrado");
        }
    }
}
