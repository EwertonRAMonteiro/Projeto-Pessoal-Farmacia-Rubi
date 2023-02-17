package br.com.farmacia.rubi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "produtos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produtos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @Column(name = "nome", nullable = false, length = 35)
    private String nome;

    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

    @Column(name = "preco", nullable = false)
    private Float preco;

    @Column(name = "tipo", nullable = false, length = 45)
    private String tipo;

    @Column(name = "data_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataTime;

    @Column(name = "descricao", nullable = false, length = 45)
    private String descricao;

    @ManyToMany(cascade = {
            CascadeType.ALL
    }, mappedBy = "produtos")
    List<Vendas> vendas;

    @ManyToMany(cascade = {
            CascadeType.ALL
    }, mappedBy = "produtos")
    List<Fornecedor> fornecedors;

}
