package br.com.farmacia.rubi.entities;

import br.com.farmacia.rubi.dto.EnderecoForRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "endereco_for")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnderecoFor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @Column(name = "rua", nullable = false, length = 45)
    private String rua;

    @Column(name = "numero", nullable = false, length = 5)
    private Short numero;

    @Column(name = "bairro", nullable = false, length = 30)
    private String bairro;

    @Column(name = "cidade", nullable = false, length = 30)
    private String cidade;

    @Column(name = "cep", nullable = false, length = 8)
    private String cep;

    @Column(name = "uf", nullable = false, length = 25)
    private String uf;

    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;

    public EnderecoFor(Long id) {this.id = id;}

    public static EnderecoFor of(EnderecoForRequest request) {
        return EnderecoFor
                .builder()
                .rua(request.getRua())
                .numero(request.getNumero())
                .bairro(request.getBairro())
                .cidade(request.getCidade())
                .cep(request.getCep())
                .uf(request.getUf())
                .build();
    }
}
