package br.com.farmacia.rubi.services;

import br.com.farmacia.rubi.dto.response.EnderecoFuncResponse;
import br.com.farmacia.rubi.entities.EnderecoFunc;
import br.com.farmacia.rubi.repositories.EnderecoFuncRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoFuncService {

    @Autowired
    private EnderecoFuncRepositoy  repository;

    public EnderecoFuncResponse findById(Long id){
        EnderecoFunc enderecoFunc = repository.findById(id).get();
        EnderecoFuncResponse response = new EnderecoFuncResponse(enderecoFunc);
        return response;
    }
}
