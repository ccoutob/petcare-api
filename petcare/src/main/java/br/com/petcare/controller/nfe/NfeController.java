package br.com.petcare.controller.nfe;

import br.com.petcare.dto.nfe.DetalhesNfe;
import br.com.petcare.dto.petshop.DetalhesPetshop;
import br.com.petcare.repository.nfe.NfeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("nfe")
@Controller
public class NfeController {

    @Autowired
    private NfeRepository repository;

    @GetMapping
    public ResponseEntity<List<DetalhesNfe>> listar(Pageable pageable){
        var lista = repository.findAll(pageable)
                .stream().map(DetalhesNfe::new).toList();
        return ResponseEntity.ok(lista);
    }
}
