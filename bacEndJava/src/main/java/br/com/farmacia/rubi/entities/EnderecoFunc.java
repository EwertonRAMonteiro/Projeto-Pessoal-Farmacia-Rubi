package br.com.farmacia.rubi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "endereco_func")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoFunc {

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
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

}
