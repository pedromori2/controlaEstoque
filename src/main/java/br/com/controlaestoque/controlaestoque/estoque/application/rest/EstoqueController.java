package br.com.controlaestoque.controlaestoque.estoque.application.rest;

import br.com.controlaestoque.controlaestoque.estoque.application.rest.dto.request.EstoqueRequest;
import br.com.controlaestoque.controlaestoque.estoque.application.rest.dto.response.EstoqueResponse;
import br.com.controlaestoque.controlaestoque.estoque.application.rest.service.EstoqueMediator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/estoques")
public class EstoqueController {

    private final EstoqueMediator mediator;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EstoqueResponse> getEstoques(){
        return mediator.getEstoques();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EstoqueResponse createEstoque(@RequestBody @Valid EstoqueRequest estoqueRequest) {
        return mediator.create(estoqueRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EstoqueResponse update(@PathVariable Integer id, @RequestBody EstoqueRequest request) {
        return mediator.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        mediator.delete(id);
    }

}
