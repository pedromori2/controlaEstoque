package br.com.controlaestoque.controlaestoque.produto.application.rest.validation;

import br.com.controlaestoque.controlaestoque.produto.domain.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProdutoValidation {

    private final ProdutoRepository repository;


}
