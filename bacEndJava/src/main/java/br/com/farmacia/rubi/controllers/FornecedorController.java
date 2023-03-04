package br.com.farmacia.rubi.controllers;

import br.com.farmacia.rubi.ResourceNotFoundException;
import br.com.farmacia.rubi.dto.request.FornecedorRequest;
import br.com.farmacia.rubi.entities.Fornecedor;
import br.com.farmacia.rubi.repositories.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RequestMapping("farmaciarubi")
@RestController
public class FornecedorController {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @GetMapping("fornecedores")
    public List<Fornecedor> getAllFornecedores() {return  fornecedorRepository.findAll();}

    @GetMapping("fornecedores/{id}")
    public ResponseEntity<Fornecedor> getForcenedorById(@PathVariable Long id) {
        Fornecedor fornecedor = fornecedorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("fornecedor inexistente"));

        return ResponseEntity.ok(fornecedor);
    }

    @PostMapping("fornecedores")
    public Fornecedor createFornecedor(@RequestBody FornecedorRequest request) {
        return fornecedorRepository.save(Fornecedor.of(request));
    }

    @PutMapping("fornecedores/{id}")
    public ResponseEntity<Fornecedor> updateFornecedor(@PathVariable Long id, @RequestBody FornecedorRequest request){
        fornecedorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("fornecedor não existe"));

        var fornecedor = Fornecedor.of(request);
        fornecedor.setId(id);

        Fornecedor newFornecedor = fornecedorRepository.save(fornecedor);

        return ResponseEntity.ok(newFornecedor);
    }

    @DeleteMapping("fornecedores/{id}")
    public  ResponseEntity<Map<String, Boolean>> deleteFornecedor(@PathVariable Long id) {
        Fornecedor fornecedor = fornecedorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("fornecedor não existe"));

        fornecedorRepository.delete(fornecedor);
        Map<String, Boolean> response = new HashMap<>();
        response.put("fornecedor deletado", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
