package br.com.controlaestoque.controlaestoque.produto.domain.repository;

import br.com.controlaestoque.controlaestoque.produto.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
