package br.com.controlaestoque.controlaestoque.estoque.domain.repository;

import br.com.controlaestoque.controlaestoque.estoque.domain.ProdutoEstoque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoEstoqueRepository extends JpaRepository<ProdutoEstoque, Integer> {

}
