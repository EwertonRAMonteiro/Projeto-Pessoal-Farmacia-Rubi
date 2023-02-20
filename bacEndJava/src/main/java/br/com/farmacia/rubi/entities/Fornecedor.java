package br.com.farmacia.rubi.entities;

import br.com.farmacia.rubi.dto.FornecedorRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "fornecedor")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @Column(name = "nome_fantasia", nullable = false, length = 50)
    private String nomeFantasia;

    @Column(name = "razao_social", nullable = false, length = 50)
    private  String razaoSocial;

    @Column(name = "telefone", nullable = false, length = 12)
    private Integer telefone;

    @Column(name = "email", nullable = false, length = 45, unique = true)
    private String email;

    @Column(name = "cnpj", nullable = false, length = 14, unique = true)
    private Integer cnpj;

    @OneToMany(mappedBy = "fornecedor", cascade = CascadeType.ALL)
    private List<EnderecoFor> enderecoFors = new ArrayList<EnderecoFor>();

    @ManyToMany(cascade = {
            CascadeType.ALL
    })
    @JoinTable(name = "produto_fornecedor",
            joinColumns = {@JoinColumn(name="produto_id")},
            inverseJoinColumns = {@JoinColumn(name="fornecedor_id")}
    )
    private List<Produto> produtos;

    public Fornecedor(Long id) {this.id = id;}

    public static Fornecedor of(FornecedorRequest request) {
        return Fornecedor
                .builder()
                .nomeFantasia(request.getNomeFantasia())
                .razaoSocial(request.getRazaoSocial())
                .telefone(request.getTelefone())
                .cnpj(request.getCnpj())
                .email(request.getEmail())
                .build();
    }

}
