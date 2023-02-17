package br.com.farmacia.rubi.entities;

import br.com.farmacia.rubi.unums.VendasEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "vendas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vendas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;


    @Column(name = "forma_pag", nullable = false)
    private VendasEnum formaPag;

    @Column(name = "valor_total", nullable = false)
    private Float valorTotal;

    @Column(name = "data_compra", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataComp;

    @Column(name = "vendedor", nullable = false)
    private Byte vendedor;

    @ManyToMany(cascade = {
            CascadeType.ALL
    })
    @JoinTable(name = "produtos_vendas",
            joinColumns = {@JoinColumn(name="produtos_id")},
            inverseJoinColumns = {@JoinColumn(name="vendas_id")}
    )
    private List<Produtos> produtos;


}
