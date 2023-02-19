package br.com.farmacia.rubi.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioRequest {

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

    private Date dataTime;

}
