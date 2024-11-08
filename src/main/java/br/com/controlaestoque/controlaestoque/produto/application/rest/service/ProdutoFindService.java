package br.com.controlaestoque.controlaestoque.produto.application.rest.service;

import br.com.controlaestoque.controlaestoque.produto.application.rest.dto.response.ProdutoResponse;
import br.com.controlaestoque.controlaestoque.produto.domain.Produto;
import br.com.controlaestoque.controlaestoque.produto.domain.repository.ProdutoRepository;
import br.com.controlaestoque.controlaestoque.produto.estructures.mapper.ProdutoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor

public class ProdutoFindService {

    private final ProdutoRepository repository;
    private final ProdutoMapper mapper;

    public List<ProdutoResponse> findAll() {
        List<Produto> produtos = repository.findAll();

        return produtos.stream().map(produto -> mapper.toProdutoResponse(produto)).collect(toList());
    }

    public ProdutoResponse findById(Integer id) {
        Produto produto = repository.findById(id).orElseThrow();
        return mapper.toProdutoResponse(produto);

    }

}
