package br.com.farmacia.rubi.entities;

import br.com.farmacia.rubi.dto.request.VendasRequest;
import br.com.farmacia.rubi.unums.VendasEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "vendas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vendas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;


    @Enumerated(EnumType.STRING)
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
    private List<Produto> produtos;

    public Vendas of(VendasRequest request) {
        return Vendas
                .builder()
                .formaPag(request.getFormaPag())
                .dataComp(request.getDataComp())
                .vendedor(request.getVendedor())
                .valorTotal(request.getValorTotal())
                .build();
    }


}
