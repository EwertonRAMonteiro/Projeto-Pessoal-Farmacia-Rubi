package br.com.farmacia.rubi.repositories;

import br.com.farmacia.rubi.entities.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutosRepository extends JpaRepository<Produtos, Long> {
}
