package br.com.controlaestoque.controlaestoque;

import br.com.controlaestoque.controlaestoque.produto.application.rest.ProdutoController;
import br.com.controlaestoque.controlaestoque.produto.application.rest.dto.request.ProdutoRequest;
import br.com.controlaestoque.controlaestoque.produto.application.rest.dto.response.ProdutoResponse;
import br.com.controlaestoque.controlaestoque.produto.application.rest.service.ProdutoMediator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProdutoControllerTests {

	@InjectMocks
	private ProdutoController controller;

	@Mock
	private ProdutoMediator mediator;

	@Test
	void getProdutos_deveRetornarListaDeProdutos() {
		List<ProdutoResponse> produtos = List.of(
				new ProdutoResponse(1, "Produto A","Produto A", BigDecimal.valueOf(10)),
				new ProdutoResponse(2, "Produto B", "Produto B", BigDecimal.valueOf(20))
		);

		when(mediator.getProdutos()).thenReturn(produtos);

		List<ProdutoResponse> resultado = controller.getProdutos();

		assertEquals(2, resultado.size());
		assertEquals("Produto A", resultado.get(0).getNome());
		verify(mediator).getProdutos();
	}

	@Test
	void createProduto_deveRetornarProdutoCriado() {
		ProdutoRequest request = new ProdutoRequest("Produto Novo", "Produto Novo", BigDecimal.valueOf(99.9));
		ProdutoResponse response = new ProdutoResponse(1, "Produto Novo", "Produto Novo", BigDecimal.valueOf(99.9));

		when(mediator.create(request)).thenReturn(response);

		ProdutoResponse resultado = controller.createProduto(request);

		assertEquals("Produto Novo", resultado.getNome());
		assertEquals(BigDecimal.valueOf(99.9), resultado.getPreco());
		verify(mediator).create(request);
	}

	@Test
	void update_deveRetornarProdutoAtualizado() {
		ProdutoRequest request = new ProdutoRequest("Produto Atualizado", "Produto Atualizado", BigDecimal.valueOf(59.9));
		ProdutoResponse response = new ProdutoResponse(1, "Produto Atualizado", "Produto Atualizado",  BigDecimal.valueOf(59.9));

		when(mediator.update(1, request)).thenReturn(response);

		ProdutoResponse resultado = controller.update(1, request);

		assertEquals("Produto Atualizado", resultado.getNome());
		verify(mediator).update(1, request);
	}

	@Test
	void delete_deveChamarMediatorDelete() {
		doNothing().when(mediator).delete(1);

		controller.delete(1);

		verify(mediator).delete(1);
	}

}
