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
public class ProdutoUpdateService {

    private final ProdutoRepository repository;
    private final ProdutoMapper mapper;
    private final ProdutoValidation validation;

    public ProdutoResponse update(Integer id, ProdutoRequest request) {
        Produto produto = repository.findById(id).map(p -> {

            validation.validaProduto(request.getNome());
            p.setNome(request.getNome());
            p.setDescricao(request.getDescricao());
            p.setPreco(request.getPreco());
            return repository.save(p);
        }).orElseThrow();

        return mapper.toProdutoResponse(produto);
    }


}
