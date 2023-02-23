package br.com.farmacia.rubi.dto;

import br.com.farmacia.rubi.entities.Fornecedor;
import jakarta.persistence.Column;

public class FornecedorResponse {
    private Long id;
    private String nomeFantasia;
    private  String razaoSocial;
    private Integer telefone;
    private String email;
    private Integer cnpj;

    public FornecedorResponse(Fornecedor fornecedor){
        id = fornecedor.getId();
        nomeFantasia = fornecedor.getNomeFantasia();
        razaoSocial = fornecedor.getRazaoSocial();
        telefone = fornecedor.getTelefone();
        cnpj = fornecedor.getCnpj();
        email = fornecedor.getEmail();
    }
}
