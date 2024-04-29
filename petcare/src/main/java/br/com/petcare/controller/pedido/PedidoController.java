package br.com.petcare.controller.pedido;

import br.com.petcare.dto.pedido.AtualizacaoPedido;
import br.com.petcare.dto.pedido.CadastroPedido;
import br.com.petcare.dto.pedido.DetalhesPedido;
import br.com.petcare.model.pedido.Pedido;
import br.com.petcare.repository.pedido.PedidoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RequestMapping("pedidos")
@Controller
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping
    public ResponseEntity<List<DetalhesPedido>> listar(Pageable pageable){
        var lista = pedidoRepository.findAll(pageable)
                .stream().map(DetalhesPedido::new).toList();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("{id}")
    public ResponseEntity<DetalhesPedido> buscar(@PathVariable("id") Long id){
        var pedido = pedidoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesPedido(pedido));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesPedido> create(@RequestBody @Valid CadastroPedido dto,
                                                  UriComponentsBuilder uriBuilder) {
        var pedido = new Pedido(dto);
        pedidoRepository.save(pedido);
        var url = uriBuilder.path("/posts/{id}").buildAndExpand(pedido.getCodigo()).toUri();
        return ResponseEntity.created(url).body(new DetalhesPedido(pedido));
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesPedido> atualizar(@PathVariable("id") Long id,
                                                    @RequestBody AtualizacaoPedido pedidoPut){
        var pedido = pedidoRepository.getReferenceById(id);
        pedido.atualizar(pedidoPut);
        return ResponseEntity.ok(new DetalhesPedido(pedido));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        pedidoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
