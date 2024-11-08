package br.com.controlaestoque.controlaestoque.estoque.domain.repository;

import br.com.controlaestoque.controlaestoque.estoque.domain.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends JpaRepository<Estoque, Integer> {
}
