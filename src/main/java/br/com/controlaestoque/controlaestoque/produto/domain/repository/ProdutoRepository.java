package br.com.controlaestoque.controlaestoque.produto.domain.repository;

import br.com.controlaestoque.controlaestoque.produto.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END FROM Produto p WHERE p.descricao = :descricao")
    boolean existsByDescricao(String descricao);

}
