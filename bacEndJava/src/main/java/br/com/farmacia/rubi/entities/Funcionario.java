package br.com.farmacia.rubi.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "funcionario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @Column(name = "first_name", nullable = false, length = 25)
    private String firstName;

    @Column(name = "mid_name", nullable = true, length = 25)
    private String midName;

    @Column(name = "last_name", nullable = false, length = 25)
    private String lastName;

    @Column(name = "data_nascimento", nullable = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataNasc;

    @Column(name = "email", nullable = false, length = 45, unique = true)
    private String email;

    @Column(name = "telefone", nullable = false, length = 50)
    private Integer telefone;

    @Column(name = "salario", nullable = false)
    private Float salario;

    @Column(name = "funcao", nullable = false)
    private String funcao;

    @Column(name = "credencial", nullable = false, unique = true)
    private Byte credencial;

    @Column(name = "cpf", nullable = false, unique = true)
    private Integer cpf;

    @Column(name = "data_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataTime;

    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL)
    private List<EnderecoFunc> enderecoFuncs = new ArrayList<EnderecoFunc>();


}
