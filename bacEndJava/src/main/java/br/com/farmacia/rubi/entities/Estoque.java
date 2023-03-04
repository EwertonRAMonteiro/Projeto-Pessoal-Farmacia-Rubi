package br.com.farmacia.rubi.entities;

import br.com.farmacia.rubi.dto.request.EstoqueRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "estoque")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Estoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @Column(name = "qnt_entrada", nullable = false)
    private Integer qntEntrada;

    @Column(name = "qnt_saida", nullable = false)
    private Integer qntSaida;

    @Column(name = "qnt_total", nullable = false)
    private Integer qntTotal;

    @Column(name = "data_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataTime;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    public Estoque(Long id) {this.id = id;}

    public  static Estoque of(EstoqueRequest request) {
        return Estoque
                .builder()
                .qntEntrada(request.getQntEntrada())
                .qntSaida(request.getQntSaida())
                .dataTime(request.getDataTime())
                .produto(new Produto(request.getProdutosId()))
                .build();
    }

}
