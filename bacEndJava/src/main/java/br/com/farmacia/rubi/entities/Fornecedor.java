package br.com.farmacia.rubi.entities;

import br.com.farmacia.rubi.dto.request.FornecedorRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @OneToMany(mappedBy = "fornecedor", fetch = FetchType.LAZY)
    private List<EnderecoFor> enderecoFors = new ArrayList<EnderecoFor>();

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "fornecedor_produtos",
            uniqueConstraints = @UniqueConstraint(columnNames = {"fornecedor_id","produto_id"}),
            joinColumns = @JoinColumn(name = "fornecedor_id"),
            inverseJoinColumns = @JoinColumn (name = "produto_id")
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
