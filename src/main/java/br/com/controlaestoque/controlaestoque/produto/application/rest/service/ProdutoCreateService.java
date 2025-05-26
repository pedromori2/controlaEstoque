package br.com.controlaestoque.controlaestoque.produto.application.rest.service;

import br.com.controlaestoque.controlaestoque.produto.application.rest.dto.request.ProdutoRequest;
import br.com.controlaestoque.controlaestoque.produto.application.rest.dto.response.ProdutoResponse;
import br.com.controlaestoque.controlaestoque.produto.application.rest.validation.ProdutoValidation;
import br.com.controlaestoque.controlaestoque.produto.domain.Produto;
import br.com.controlaestoque.controlaestoque.produto.domain.repository.ProdutoRepository;
import br.com.controlaestoque.controlaestoque.produto.estructures.mapper.ProdutoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProdutoCreateService {

    private final ProdutoRepository produtoRepository;
    private final ProdutoMapper mapper;
    private final ProdutoValidation validation;

    public ProdutoResponse create(ProdutoRequest produtoRequest) {
        Produto produto = mapper.requestToProduto(produtoRequest);
        validation.validaProduto(produto.getNome());
        produtoRepository.save(produto);
        return mapper.toProdutoResponse(produto);

    }

}
