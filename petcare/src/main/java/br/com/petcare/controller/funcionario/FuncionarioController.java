package br.com.petcare.controller.funcionario;

import br.com.petcare.dto.funcionario.AtualizacaoFuncionario;
import br.com.petcare.dto.funcionario.CadastroFuncionario;
import br.com.petcare.dto.funcionario.DetalhesFuncionario;
import br.com.petcare.model.funcionario.Funcionario;
import br.com.petcare.repository.funcionario.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RequestMapping("funcionarios")
@Controller
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository repository;

    @GetMapping
    public ResponseEntity<List<DetalhesFuncionario>> listar(Pageable pageable){
        var lista = repository.findAll(pageable)
                .stream().map(DetalhesFuncionario::new).toList();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("{id}")
    public ResponseEntity<DetalhesFuncionario> buscar(@PathVariable("id") Long id){
        var funcionario = repository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesFuncionario(funcionario));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesFuncionario> cadastrar(@RequestBody CadastroFuncionario funcionarioPost,
                                                         UriComponentsBuilder uri){
        var funcionario = new Funcionario(funcionarioPost);
        repository.save(funcionario);
        var url = uri.path("/funcionarios/{id}").buildAndExpand(funcionario.getCodigo()).toUri();
        return ResponseEntity.created(url).body(new DetalhesFuncionario(funcionario));
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesFuncionario> atualizar(@PathVariable("id") Long id,
                                                         @RequestBody AtualizacaoFuncionario funcionarioPut){
        var funcionario = repository.getReferenceById(id);
        funcionario.atualizarDados(funcionarioPut);
        return ResponseEntity.ok(new DetalhesFuncionario(funcionario));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
