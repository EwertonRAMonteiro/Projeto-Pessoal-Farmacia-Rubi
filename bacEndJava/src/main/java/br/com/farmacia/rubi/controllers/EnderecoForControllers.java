package br.com.farmacia.rubi.controllers;

import br.com.farmacia.rubi.ResourceNotFoundException;
import br.com.farmacia.rubi.dto.request.EnderecoForRequest;
import br.com.farmacia.rubi.dto.response.EnderecoForResponse;
import br.com.farmacia.rubi.dto.response.EnderecoFuncResponse;
import br.com.farmacia.rubi.entities.EnderecoFor;
import br.com.farmacia.rubi.repositories.EnderecoForRepository;
import br.com.farmacia.rubi.repositories.FornecedorRepository;
import br.com.farmacia.rubi.services.EnderecoForService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RequestMapping("farmaciarubi")
@RestController
public class EnderecoForControllers {

    @Autowired
    private EnderecoForRepository enderecoForRepository;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    private EnderecoForService service;

    @GetMapping("fornecedores/enderecos")
    public List<EnderecoFor> getAllEnderecos(){return enderecoForRepository.findAll();}

//    @GetMapping("fornecedores/enderecos/{id}")
//    public ResponseEntity<EnderecoFor> findEnderecoById(@PathVariable Long id){
//        EnderecoFor enderecoFor = enderecoForRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Endereco Inexistente"));
//        return ResponseEntity.ok(enderecoFor);
//    }

//    @GetMapping("fornecedores/enderecos/{id}")
//    public EnderecoForResponse findById(@PathVariable Long id){
//        EnderecoForResponse response = service.findById(id);
//        return response;
//    }


    @GetMapping("fornecedores/enderecos/{id}")
    public EnderecoForResponse findById(@PathVariable Long id){ return service.findById(id);
    }

    @GetMapping("fornecedores/enderecos/lista/{id}")
    public ResponseEntity<List<EnderecoFor>> listAllenderecosOfFornecedor(@PathVariable("id") Long id){
        var fornecedor = fornecedorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("lista de enderecos de fornecedores Inexistente"));
        var enderecofors = fornecedor.getEnderecoFors();

        return ResponseEntity.ok(enderecofors);
    }

    @PostMapping("fornecedores/enderecos")
    public EnderecoFor createEnderecoFor(@RequestBody EnderecoForRequest request){
        return enderecoForRepository.save(EnderecoFor.of(request));
    }

    @PutMapping("fornecedores/enderecos/{id}")
    public ResponseEntity<EnderecoFor> updateEnderecoFor
            (@PathVariable Long id, @RequestBody EnderecoForRequest request){
        enderecoForRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("lista de enderecos de funcionarios Inexistente"));

        var enderecoFor = EnderecoFor.of(request);
        enderecoFor.setId(id);

        EnderecoFor newEnderecoFor = enderecoForRepository.save(enderecoFor);
        return ResponseEntity.ok(newEnderecoFor);

    }

    @DeleteMapping("fornecedores/enderecos/{id}")
    public ResponseEntity<Map<String, Boolean>> getEnderecoForRepository(@PathVariable Long id) {
        EnderecoFor enderecoFor = enderecoForRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("lista de enderecos de funcionarios Inexistente"));

        enderecoForRepository.delete(enderecoFor);
        Map<String, Boolean> response = new HashMap<>();
        response.put("endereco deletado", Boolean.TRUE);
        return ResponseEntity.ok(response);

    }
}
