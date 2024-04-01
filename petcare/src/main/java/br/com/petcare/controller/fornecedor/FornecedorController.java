package br.com.petcare.controller.fornecedor;

import br.com.petcare.dto.fornecedor.AtualizacaoFornecedor;
import br.com.petcare.dto.fornecedor.CadastroFornecedor;
import br.com.petcare.dto.fornecedor.DetalhesFornecedor;
import br.com.petcare.model.fornecedor.Fornecedor;
import br.com.petcare.repository.fornecedor.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Controller
@RequestMapping("fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorRepository repository;

    @GetMapping
    public ResponseEntity<List<DetalhesFornecedor>> listar(Pageable pageable){
        var lista = repository.findAll(pageable)
                .stream().map(DetalhesFornecedor::new).toList();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("{id}")
    public ResponseEntity<DetalhesFornecedor> buscar(@PathVariable("id") Long id){
        var fornecedor = repository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesFornecedor(fornecedor));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesFornecedor> cadastrar(@RequestBody CadastroFornecedor fornecedorPost,
                                                        UriComponentsBuilder uri){
        var fornecedor = new Fornecedor(fornecedorPost);
        repository.save(fornecedor);
        var url = uri.path("/fornecedor/{id}").buildAndExpand(fornecedor.getCodigo()).toUri();
        return ResponseEntity.created(url).body(new DetalhesFornecedor(fornecedor));
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesFornecedor> atualizar(@PathVariable("id") Long id,
                                                        @RequestBody AtualizacaoFornecedor fornecedorPut){
        var fornecedor = repository.getReferenceById(id);
        fornecedor.atualizarDados(fornecedorPut);
        return ResponseEntity.ok(new DetalhesFornecedor(fornecedor));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
