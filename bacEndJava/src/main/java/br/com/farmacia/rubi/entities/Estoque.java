package br.com.farmacia.rubi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "estoque")
@Data
@NoArgsConstructor
@AllArgsConstructor
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



}
