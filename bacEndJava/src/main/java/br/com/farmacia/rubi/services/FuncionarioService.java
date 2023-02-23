package br.com.farmacia.rubi.services;

import br.com.farmacia.rubi.dto.FuncionarioResponse;
import br.com.farmacia.rubi.entities.Funcionario;
import br.com.farmacia.rubi.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

    @Autowired
    FuncionarioRepository repository;
    public FuncionarioResponse findById(Long id){
        Funcionario funcionario = repository.findById(id).get();
        FuncionarioResponse response = new FuncionarioResponse(funcionario);
        return response;
    }
}
