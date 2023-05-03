package br.com.farmacia.rubi.services;

import br.com.farmacia.rubi.ResourceNotFoundException;
import br.com.farmacia.rubi.dto.response.EnderecoForResponse;
import br.com.farmacia.rubi.entities.EnderecoFor;
import br.com.farmacia.rubi.repositories.EnderecoForRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class EnderecoForService {

    @Autowired
    private EnderecoForRepository repository;

    public EnderecoForResponse findById(Long id){

            EnderecoFor enderecoFor = repository.findById(id).get();
            EnderecoForResponse response = new EnderecoForResponse(enderecoFor);
            return response;
    }

}
