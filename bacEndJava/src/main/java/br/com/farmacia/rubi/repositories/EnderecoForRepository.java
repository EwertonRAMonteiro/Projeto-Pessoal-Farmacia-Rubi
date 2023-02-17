package br.com.farmacia.rubi.repositories;

import br.com.farmacia.rubi.entities.EnderecoFor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoForRepository extends JpaRepository<EnderecoFor,Long> {
}
