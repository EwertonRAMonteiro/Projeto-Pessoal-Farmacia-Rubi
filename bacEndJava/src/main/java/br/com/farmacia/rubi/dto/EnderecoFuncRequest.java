package br.com.farmacia.rubi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoFuncRequest {


    private String rua;

    private Short numero;

    private String bairro;

    private String cidade;

    private String cep;

    private String uf;

}
