package br.com.farmacia.rubi.dto.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoForRequest {
    private String rua;

    private Short numero;

    private String bairro;

    private String cidade;

    private String cep;

    private String uf;

    private Long fornecedorId;
}
