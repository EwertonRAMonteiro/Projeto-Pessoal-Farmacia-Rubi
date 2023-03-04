package br.com.farmacia.rubi.services;

import br.com.farmacia.rubi.dto.response.FornecedorResponse;
import br.com.farmacia.rubi.entities.Fornecedor;
import br.com.farmacia.rubi.repositories.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository repository;

    public FornecedorResponse findById(Long id){
        Fornecedor fornecedor = repository.findById(id).get();
        FornecedorResponse response = new FornecedorResponse(fornecedor);
        return response;

    }
}
