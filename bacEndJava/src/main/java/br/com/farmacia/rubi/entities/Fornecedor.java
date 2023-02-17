package br.com.farmacia.rubi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "fornecedor")
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    private String cnpj;

    @OneToMany(mappedBy = "fornecedor", cascade = CascadeType.ALL)
    private List<EnderecoFor> enderecoFors = new ArrayList<EnderecoFor>();

    @ManyToMany(cascade = {
            CascadeType.ALL
    })
    @JoinTable(name = "produtos_fornecedors",
            joinColumns = {@JoinColumn(name="produtos_id")},
            inverseJoinColumns = {@JoinColumn(name="fornecedor_id")}
    )
    private List<Produtos> produtos;


}
