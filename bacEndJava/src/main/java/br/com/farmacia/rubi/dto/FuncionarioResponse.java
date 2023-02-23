package br.com.farmacia.rubi.dto;

import br.com.farmacia.rubi.entities.Funcionario;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioResponse {

    private Long id;
    private String firstName;
    private String midName;
    private String lastName;
    private Date dataNasc;
    private String email;
    private Integer telefone;
    private Float salario;
    private String funcao;
    private Byte credencial;
    private Integer cpf;

    public FuncionarioResponse(Funcionario funcionario) {
        id = funcionario.getId();
        firstName = funcionario.getFirstName();
        midName = funcionario.getMidName();
        lastName = funcionario.getLastName();
        dataNasc = funcionario.getDataNasc();
        email = funcionario.getEmail();
        telefone = funcionario.getTelefone();
        salario = funcionario.getSalario();
        funcao = funcionario.getFuncao();
        credencial = funcionario.getCredencial();
        cpf = funcionario.getCpf();
    }
}
