package br.com.farmacia.rubi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequest {

    private Float valorVenda;

    private Float valorCompra;

    private String nome;

    private String tipo;

    private String descricao;
}
