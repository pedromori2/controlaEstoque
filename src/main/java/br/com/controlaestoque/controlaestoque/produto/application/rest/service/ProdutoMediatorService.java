package br.com.controlaestoque.controlaestoque.produto.application.rest.service;

import br.com.controlaestoque.controlaestoque.produto.application.rest.dto.request.ProdutoRequest;
import br.com.controlaestoque.controlaestoque.produto.application.rest.dto.response.ProdutoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProdutoMediatorService implements ProdutoMediator {

    private final ProdutoFindService produtoFindService;
    private final ProdutoCreateService produtoCreateService;
    private final ProdutoUpdateService produtoUpdateService;
    private final ProdutoDeleteService produtoDeleteService;

    @Override
    public List<ProdutoResponse> getProdutos() {
        return produtoFindService.findAll();
    }

    @Override
    public ProdutoResponse create(ProdutoRequest request) {
        return produtoCreateService.create(request);
    }

    @Override
    public ProdutoResponse update(Integer id, ProdutoRequest request) {
        return produtoUpdateService.update(id, request);
    }

    @Override
    public void delete(Integer id) {
        produtoDeleteService.delete(id);
    }
}
