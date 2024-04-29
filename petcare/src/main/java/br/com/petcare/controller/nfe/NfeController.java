package br.com.petcare.controller.nfe;

import br.com.petcare.dto.nfe.CadastroNfe;
import br.com.petcare.dto.nfe.DetalhesNfe;
import br.com.petcare.dto.petshop.DetalhesPetshop;
import br.com.petcare.model.nfe.Nfe;
import br.com.petcare.repository.nfe.NfeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RequestMapping("nfe")
@Controller
public class NfeController {

    @Autowired
    private NfeRepository nfeRepository;

}
