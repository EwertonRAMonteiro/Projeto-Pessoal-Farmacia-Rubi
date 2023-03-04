package br.com.farmacia.rubi.entities;

import br.com.farmacia.rubi.dto.request.ProdutoRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "produtos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @Column(name = "valor_venda", nullable = false)
    private Float valorVenda;

    @Column(name = "valor_compra", nullable = false)
    private Float valorCompra;

    @Column(name = "nome", nullable = false, length = 45)
    private String nome;

    @Column(name = "tipo", nullable = false, length = 45)
    private String tipo;

    @Column(name = "descricao", nullable = false, length = 45)
    private String descricao;

    @ManyToMany(cascade = {
            CascadeType.ALL
    }, mappedBy = "produtos")
    private List<Vendas> vendas;

    @ManyToMany()
    @JoinTable(
            name = "produto_fornecedor",
            uniqueConstraints = @UniqueConstraint(columnNames = {"fornecedor_id","produto_id"}),
            joinColumns = @JoinColumn(name = "fornecedor_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private List<Fornecedor> fornecedors;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
    private List<Estoque> estoques = new ArrayList<Estoque>();

    public Produto(Long id) {this.id =id;}

    public static Produto of(ProdutoRequest request) {
        return Produto
                .builder()
                .valorCompra(request.getValorCompra())
                .valorVenda(request.getValorVenda())
                .nome(request.getNome())
                .descricao(request.getDescricao())
                .tipo(request.getTipo())
                .build();
    }

}
