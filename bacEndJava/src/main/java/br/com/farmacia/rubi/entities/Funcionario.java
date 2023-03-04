package br.com.farmacia.rubi.entities;


import br.com.farmacia.rubi.dto.request.FuncionarioRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "funcionario")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @Column(name = "first_name", nullable = false, length = 30)
    private String firstName;

    @Column(name = "mid_name", nullable = true, length = 30)
    private String midName;

    @Column(name = "last_name", nullable = false, length = 30)
    private String lastName;

    @Column(name = "data_nascimento")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataNasc;

    @Column(name = "email", nullable = false, length = 45, unique = true)
    private String email;

    @Column(name = "telefone", nullable = false, length = 14)
    private Integer telefone;

    @Column(name = "salario", nullable = false)
    private Float salario;

    @Column(name = "funcao", nullable = false, length = (25))
    private String funcao;

    @Column(name = "credencial", nullable = false, unique = true)
    private Byte credencial;

    @Column(name = "cpf", nullable = false, unique = true)
    private Integer cpf;

    @Column(name = "data_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataTime;

    @JsonIgnore
    @OneToMany(mappedBy = "funcionario", fetch = FetchType.LAZY)
    private List<EnderecoFunc> enderecoFuncs;

    public Funcionario(Long id){
        this.id = id;
    }

    public static Funcionario of(FuncionarioRequest request) {
        return Funcionario
                .builder()
                .firstName(request.getFirstName())
                .midName(request.getMidName())
                .lastName(request.getLastName())
                .cpf(request.getCpf())
                .telefone(request.getTelefone())
                .credencial(request.getCredencial())
                .dataNasc(request.getDataNasc())
                .dataTime(request.getDataTime())
                .funcao(request.getFuncao())
                .email(request.getEmail())
                .salario(request.getSalario())
                .build();
    }


}
