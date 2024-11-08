package br.com.controlaestoque.controlaestoque.produto.application.rest.service;

import br.com.controlaestoque.controlaestoque.produto.domain.repository.ProdutoRepository;
import br.com.controlaestoque.controlaestoque.produto.estructures.mapper.ProdutoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProdutoDeleteService {

    private final ProdutoRepository produtoRepository;

    public void delete(Integer id) {
        produtoRepository.deleteById(id);
    }


}
