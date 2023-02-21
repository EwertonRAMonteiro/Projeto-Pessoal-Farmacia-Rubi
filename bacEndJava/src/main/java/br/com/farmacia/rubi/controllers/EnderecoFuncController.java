package br.com.farmacia.rubi.controllers;


import br.com.farmacia.rubi.ResourceNotFoundException;
import br.com.farmacia.rubi.dto.EnderecoFuncRequest;
import br.com.farmacia.rubi.entities.EnderecoFunc;
import br.com.farmacia.rubi.repositories.EnderecoFunRepositoy;
import br.com.farmacia.rubi.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("farmaciarubi")
public class EnderecoFuncController {

    @Autowired
    private EnderecoFunRepositoy enderecoFunRepositoy;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @GetMapping("funcionarios/enderecos")
    public List<EnderecoFunc> getAllEnderecosFunc() {return enderecoFunRepositoy.findAll();}

    @GetMapping("funcionarios/enderecos/{id}")
    public ResponseEntity<EnderecoFunc> findEnderecosFuncById(@PathVariable Long id){
        EnderecoFunc enderecoFunc = enderecoFunRepositoy.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Endereco Inexistente"));
        return ResponseEntity.ok(enderecoFunc);
    }

    @GetMapping("funcionarios/enderecos/lista/{id}")
    public ResponseEntity<List<EnderecoFunc>> listAllEnderecosOfFuncionarios(@PathVariable("id") Long id){
        var funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("lista de enderecos de funcionarios Inexistente"));
        var enderecoFuncs = funcionario.getEnderecoFuncs();

        return ResponseEntity.ok(enderecoFuncs);
    }

    @PostMapping("funcionarios/enderecos")
    public EnderecoFunc creatEnderecoFunc(@RequestBody EnderecoFuncRequest request) {
        return enderecoFunRepositoy.save(EnderecoFunc.of(request));
    }

    @PutMapping("funcionarios/enderecos/{id}")
    public ResponseEntity<EnderecoFunc> updateEnderecoFunc
            (@PathVariable Long id, @RequestBody EnderecoFuncRequest request){
        enderecoFunRepositoy.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Endereco não existe"));

        var endereco = EnderecoFunc.of(request);
        endereco.setId(id);

        EnderecoFunc newEnderencoFunc = enderecoFunRepositoy.save(endereco);
        return ResponseEntity.ok(newEnderencoFunc);
    }

    @DeleteMapping("funcionarios/enderecos/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEnderecoFuc(@PathVariable Long id) {
        EnderecoFunc enderecoFunc = enderecoFunRepositoy.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("endereco inexistente"));

        enderecoFunRepositoy.delete(enderecoFunc);
        Map<String, Boolean> reponse = new HashMap<>();
        reponse.put("endereco deletado", Boolean.TRUE);

        return ResponseEntity.ok(reponse);
    }



}
