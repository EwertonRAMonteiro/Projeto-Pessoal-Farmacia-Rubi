package br.com.farmacia.rubi.repositories;

import br.com.farmacia.rubi.entities.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
