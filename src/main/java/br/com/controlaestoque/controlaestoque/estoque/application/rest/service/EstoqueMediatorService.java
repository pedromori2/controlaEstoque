package br.com.controlaestoque.controlaestoque.estoque.application.rest.service;

import br.com.controlaestoque.controlaestoque.estoque.application.rest.dto.request.EstoqueRequest;
import br.com.controlaestoque.controlaestoque.estoque.application.rest.dto.response.EstoqueResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstoqueMediatorService implements EstoqueMediator {

    private final EstoqueFindService findService;
    private final EstoqueCreateService createService;
    private final EstoqueUpdateService updateService;
    private final EstoqueDeleteService deleteService;

    @Override
    public List<EstoqueResponse> getEstoques() {
        return findService.getEstoques();
    }

    @Override
    public EstoqueResponse create(EstoqueRequest estoqueRequest) {
        return createService.create(estoqueRequest);
    }

    @Override
    public EstoqueResponse update(Integer id, EstoqueRequest request) {
        return updateService.update(id, request);
    }

    @Override
    public void delete(Integer id) {
         deleteService.delete(id);
    }
}
