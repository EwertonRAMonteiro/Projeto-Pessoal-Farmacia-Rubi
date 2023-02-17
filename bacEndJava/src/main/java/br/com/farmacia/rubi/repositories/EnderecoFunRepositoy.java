package br.com.farmacia.rubi.repositories;

import br.com.farmacia.rubi.entities.EnderecoFunc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoFunRepositoy extends JpaRepository<EnderecoFunc, Long> {
}
