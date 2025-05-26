package br.com.controlaestoque.controlaestoque;

import br.com.controlaestoque.controlaestoque.estoque.application.rest.EstoqueController;
import br.com.controlaestoque.controlaestoque.estoque.application.rest.dto.request.EstoqueRequest;
import br.com.controlaestoque.controlaestoque.estoque.application.rest.dto.response.EstoqueResponse;
import br.com.controlaestoque.controlaestoque.estoque.application.rest.service.EstoqueMediator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EstoqueController.class)
class EstoqueControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EstoqueMediator mediator;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getEstoques_deveRetornarList() throws Exception {
        EstoqueResponse estoque = new EstoqueResponse(1, "Estoque A");
        Mockito.when(mediator.getEstoques()).thenReturn(List.of(estoque));

        mockMvc.perform(get("/api/v1/estoques"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].descricao", is("Estoque A")));
    }

    @Test
    void createEstoque_deveRetornarCreated() throws Exception {
        EstoqueRequest request = new EstoqueRequest("Novo Estoque");
        EstoqueResponse response = new EstoqueResponse(1, "Novo Estoque");

        Mockito.when(mediator.create(Mockito.any(EstoqueRequest.class))).thenReturn(response);

        mockMvc.perform(post("/api/v1/estoques")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.descricao", is("Novo Estoque")));
    }

    @Test
    void updateEstoque_deveRetornarUpdated() throws Exception {
        EstoqueRequest request = new EstoqueRequest("Atualizado");
        EstoqueResponse response = new EstoqueResponse(1, "Atualizado");

        Mockito.when(mediator.update(Mockito.eq(1), Mockito.any(EstoqueRequest.class))).thenReturn(response);

        mockMvc.perform(put("/api/v1/estoques/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.descricao", is("Atualizado")));
    }

    @Test
    void deleteEstoque_deveRetornarNoContent() throws Exception {
        Mockito.doNothing().when(mediator).delete(1);

        mockMvc.perform(delete("/api/v1/estoques/1"))
                .andExpect(status().isNoContent());
    }
}
