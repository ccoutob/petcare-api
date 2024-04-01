package br.com.petcare.controller.petshop;

import br.com.petcare.dto.petshop.AtualizacaoPetshop;
import br.com.petcare.dto.petshop.CadastroPetshop;
import br.com.petcare.dto.petshop.DetalhesPetshop;
import br.com.petcare.model.petshop.Petshop;
import br.com.petcare.repository.petshop.PetshopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RequestMapping("petshops")
@Controller
public class PetshopController {

    @Autowired
    private PetshopRepository repository;

    @GetMapping
    public ResponseEntity<List<DetalhesPetshop>> listar(Pageable pageable){
        var lista = repository.findAll(pageable)
                .stream().map(DetalhesPetshop::new).toList();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("{id}")
    public ResponseEntity<DetalhesPetshop> buscar(@PathVariable("id") Long id){
        var petshop = repository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesPetshop(petshop));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesPetshop> cadastrar(@RequestBody CadastroPetshop petshopPost,
                                                     UriComponentsBuilder uri){
        var petshop = new Petshop(petshopPost);
        repository.save(petshop);
        var url = uri.path("/petshops/{id}").buildAndExpand(petshop.getCodigo()).toUri();
        return ResponseEntity.created(url).body(new DetalhesPetshop(petshop));
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesPetshop> atualizar(@PathVariable("id") Long id,
                                                     @RequestBody AtualizacaoPetshop petshopPut){
        var petshop = repository.getReferenceById(id);
        petshop.atualizarDados(petshopPut);
        return ResponseEntity.ok(new DetalhesPetshop(petshop));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}

