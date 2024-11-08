package br.com.controlaestoque.controlaestoque.produto.application.rest;

import br.com.controlaestoque.controlaestoque.produto.application.rest.dto.request.ProdutoRequest;
import br.com.controlaestoque.controlaestoque.produto.application.rest.dto.response.ProdutoResponse;
import br.com.controlaestoque.controlaestoque.produto.application.rest.service.ProdutoMediator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoMediator mediator;

    @GetMapping
    public List<ProdutoResponse> getProdutos() {
        return mediator.getProdutos();
    }

    @PostMapping
    public ProdutoResponse createProduto(@RequestBody ProdutoRequest request) {
        return mediator.create(request);
    }

    @PutMapping("/{id}")
    public ProdutoResponse update(@PathVariable Integer id, @RequestBody ProdutoRequest request) {
        return mediator.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        mediator.delete(id);
    }

}
