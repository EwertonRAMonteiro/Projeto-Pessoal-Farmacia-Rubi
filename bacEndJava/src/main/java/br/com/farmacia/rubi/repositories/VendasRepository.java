package br.com.farmacia.rubi.repositories;

import br.com.farmacia.rubi.entities.Vendas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendasRepository extends JpaRepository<Vendas, Long> {
}
