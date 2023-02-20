package br.com.farmacia.rubi.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FornecedorRequest {
    private String nomeFantasia;

    private  String razaoSocial;

    private Integer telefone;

    private String email;

    private Integer cnpj;

}
