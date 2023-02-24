package br.com.farmacia.rubi.dto;

import br.com.farmacia.rubi.entities.EnderecoFor;
import jakarta.persistence.Column;

public class EnderecoForResponse {

    private Long id;
    private String rua;
    private Short numero;
    private String bairro;
    private String cidade;
    private String cep;
    private String uf;

    public EnderecoForResponse(EnderecoFor enderecoFor){
        id = enderecoFor.getId();
        rua = enderecoFor.getRua();
        numero = enderecoFor.getNumero();
        bairro = enderecoFor.getBairro();
        cidade = enderecoFor.getCidade();
        cep = enderecoFor.getCep();
        uf = enderecoFor.getUf();
    }
}
