package br.com.controlaestoque.controlaestoque.estoque.domain.repository;

import br.com.controlaestoque.controlaestoque.estoque.domain.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EstoqueRepository extends JpaRepository<Estoque, Integer> {
    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Estoque c WHERE c.descricao = :descricao")
    boolean existsByDescricao(@Param("descricao") String descricao);
}
