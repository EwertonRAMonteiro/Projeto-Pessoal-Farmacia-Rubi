package br.com.farmacia.rubi.controllers;

import br.com.farmacia.rubi.ResourceNotFoundException;
import br.com.farmacia.rubi.dto.request.FuncionarioRequest;
import br.com.farmacia.rubi.dto.response.FuncionarioResponse;
import br.com.farmacia.rubi.entities.Funcionario;
import br.com.farmacia.rubi.repositories.FuncionarioRepository;
import br.com.farmacia.rubi.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "*")
@RequestMapping("farmaciarubi")
@RestController
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private FuncionarioService service;

    @GetMapping("funcionarios/{id}")
    public FuncionarioResponse findById(@PathVariable Long id){
        return  service.findById(id);
    }
    @GetMapping("funcionarios")
    public List<Funcionario> getAllFuncionarios(){
        return funcionarioRepository.findAll();
    }

//    @GetMapping("funcionarios/{id}")
//    public ResponseEntity<Funcionario> getFuncionarioById(@PathVariable Long id) {
//        Funcionario funcionario = funcionarioRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("funcionario inexistente"));
//
//        return ResponseEntity.ok(funcionario);
//    }

    @PostMapping("funcionarios")
    public Funcionario createFuncionario(@RequestBody FuncionarioRequest request) {
        return funcionarioRepository.save(Funcionario.of(request));
    }

    @PutMapping("funcionarios/{id}")
    public ResponseEntity<Funcionario> updateFuncionario(@PathVariable Long id,@RequestBody FuncionarioRequest request){
        funcionarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("funcionario não existe"));
        var funcionario = Funcionario.of(request);
        funcionario.setId(id);

        Funcionario newFuncionario = funcionarioRepository.save(funcionario);

        return ResponseEntity.ok(newFuncionario);
    }

    @DeleteMapping("funcionarios/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteFuncionario(@PathVariable Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("funcionario não deletado"));

        funcionarioRepository.delete(funcionario);
        Map<String, Boolean> response = new HashMap<>();
        response.put("funcionario deletado", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }


}
