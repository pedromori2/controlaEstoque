package br.com.controlaestoque.controlaestoque.produto.application.rest;

import br.com.controlaestoque.controlaestoque.produto.application.rest.dto.request.ProdutoRequest;
import br.com.controlaestoque.controlaestoque.produto.application.rest.dto.response.ProdutoResponse;
import br.com.controlaestoque.controlaestoque.produto.application.rest.service.ProdutoMediator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutoController {

    private final ProdutoMediator mediator;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProdutoResponse> getProdutos() {
        return mediator.getProdutos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoResponse createProduto(@RequestBody @Valid ProdutoRequest request) {
        return mediator.create(request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProdutoResponse update(@PathVariable Integer id, @RequestBody ProdutoRequest request) {
        return mediator.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        mediator.delete(id);
    }

}
