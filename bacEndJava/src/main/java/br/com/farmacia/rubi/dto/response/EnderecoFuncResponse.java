package br.com.farmacia.rubi.dto.response;

import br.com.farmacia.rubi.entities.EnderecoFunc;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoFuncResponse {

    private Long id;
    private String rua;
    private Short numero;
    private String bairro;
    private String cidade;
    private String cep;
    private String uf;

    public EnderecoFuncResponse(EnderecoFunc enderecoFunc){
        id = enderecoFunc.getId();
        rua = enderecoFunc.getRua();
        numero = enderecoFunc.getNumero();
        bairro = enderecoFunc.getBairro();
        cidade = enderecoFunc.getCidade();
        cep = enderecoFunc.getCep();
        uf = enderecoFunc.getUf();
    }
}
