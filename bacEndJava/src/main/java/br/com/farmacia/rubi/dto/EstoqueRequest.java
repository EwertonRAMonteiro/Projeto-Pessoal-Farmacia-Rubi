package br.com.farmacia.rubi.dto;

import br.com.farmacia.rubi.entities.Vendas;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstoqueRequest {

    private Integer qntEntrada;

    private Integer qntSaida;

    private Integer qntTotal;

    private Date dataTime;

    private Long produtosId;
}
