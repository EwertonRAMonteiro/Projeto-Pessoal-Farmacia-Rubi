package br.com.farmacia.rubi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoFor extends JpaRepository< EnderecoFor,Long> {
}
