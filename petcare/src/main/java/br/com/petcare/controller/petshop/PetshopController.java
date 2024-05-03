package br.com.petcare.controller.petshop;

import br.com.petcare.dto.cliente.CadastroCliente;
import br.com.petcare.dto.cliente.DetalhesCliente;
import br.com.petcare.dto.fornecedor.CadastroFornecedor;
import br.com.petcare.dto.fornecedor.DetalhesFornecedor;
import br.com.petcare.dto.funcionario.CadastroFuncionario;
import br.com.petcare.dto.funcionario.DetalhesFuncionario;
import br.com.petcare.dto.pedido.CadastroPedido;
import br.com.petcare.dto.pedido.DetalhesPedidoPetshop;
import br.com.petcare.dto.petshop.AtualizacaoPetshop;
import br.com.petcare.dto.petshop.CadastroPetshop;
import br.com.petcare.dto.petshop.DetalhesPetshop;
import br.com.petcare.model.cliente.Cliente;
import br.com.petcare.model.fornecedor.Fornecedor;
import br.com.petcare.model.funcionario.Funcionario;
import br.com.petcare.model.pedido.Pedido;
import br.com.petcare.model.petshop.Petshop;
import br.com.petcare.repository.cliente.ClienteRepository;
import br.com.petcare.repository.fornecedor.FornecedorRepository;
import br.com.petcare.repository.funcionario.FuncionarioRepository;
import br.com.petcare.repository.pedido.PedidoRepository;
import br.com.petcare.repository.petshop.PetshopRepository;
import jakarta.validation.Valid;
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
    private PetshopRepository petshopRepository;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    //Post da tabela Fornecedor
    @PostMapping("{id}/fornecedores")
    @Transactional
    public ResponseEntity<DetalhesFornecedor> post(@PathVariable("id") Long id,
                                                   @RequestBody @Valid CadastroFornecedor dto,
                                                   UriComponentsBuilder uriBuilder){
        //chamar o repository post para pesquisar o post pelo codigo
        var petshop = petshopRepository.getReferenceById(id);
        //instanciar o comentário com o dto
        var fornecedor = new Fornecedor(dto, petshop);
        fornecedorRepository.save(fornecedor);
        var uri = uriBuilder.path("fornecedores/{id}").buildAndExpand(fornecedor.getCodigo()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesFornecedor(fornecedor));
    }

    //Post da tabela Funcionario
    @PostMapping("{id}/funcionarios")
    @Transactional
    public ResponseEntity<DetalhesFuncionario> post(@PathVariable("id") Long id,
                                                    @RequestBody @Valid CadastroFuncionario dto,
                                                    UriComponentsBuilder uriBuilder){
        //chamar o repository post para pesquisar o post pelo codigo
        var petshop = petshopRepository.getReferenceById(id);
        //instanciar o comentário com o dto
        var funcionario = new Funcionario(dto, petshop);
        funcionarioRepository.save(funcionario);
        var uri = uriBuilder.path("funcionarios/{id}").buildAndExpand(funcionario.getCodigo()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesFuncionario(funcionario));
    }

    //Post da tabela Pedido
    @PostMapping("{id}/pedidos")
    @Transactional
    public ResponseEntity<DetalhesPedidoPetshop> post(@PathVariable("id") Long id,
                                                      @RequestBody @Valid CadastroPedido dto,
                                                      UriComponentsBuilder uriBuilder){
        //chamar o repository post para pesquisar o post pelo codigo
        var petshop = petshopRepository.getReferenceById(id);
        //instanciar o comentário com o dto
        var pedido = new Pedido(dto, petshop);
        pedidoRepository.save(pedido);
        var uri = uriBuilder.path("pedidos/{id}").buildAndExpand(pedido.getCodigo()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesPedidoPetshop(pedido));
    }

    //Post da tabela Cliente
    @PostMapping("{id}/clientes")
    @Transactional
    public ResponseEntity<DetalhesCliente> post(@PathVariable("id") Long id,
                                                @RequestBody @Valid CadastroCliente dto,
                                                UriComponentsBuilder uriBuilder){
        //chamar o repository post para pesquisar o post pelo codigo
        var petshop = petshopRepository.getReferenceById(id);
        //instanciar o comentário com o dto
        var cliente = new Cliente(dto, petshop);
        clienteRepository.save(cliente);
        var uri = uriBuilder.path("clientes/{id}").buildAndExpand(cliente.getCodigo()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesCliente(cliente));
    }

    @GetMapping
    public ResponseEntity<List<DetalhesPetshop>> listar(Pageable pageable){
        var lista = petshopRepository.findAll(pageable)
                .stream().map(DetalhesPetshop::new).toList();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("{id}")
    public ResponseEntity<DetalhesPetshop> buscar(@PathVariable("id") Long id){
        var petshop = petshopRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesPetshop(petshop));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesPetshop> cadastrar(@RequestBody CadastroPetshop petshopPost,
                                                     UriComponentsBuilder uri){
        var petshop = new Petshop(petshopPost);
        petshopRepository.save(petshop);
        var url = uri.path("/petshops/{id}").buildAndExpand(petshop.getCodigo()).toUri();
        return ResponseEntity.created(url).body(new DetalhesPetshop(petshop));
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesPetshop> atualizar(@PathVariable("id") Long id,
                                                     @RequestBody AtualizacaoPetshop petshopPut){
        var petshop = petshopRepository.getReferenceById(id);
        petshop.atualizarDados(petshopPut);
        return ResponseEntity.ok(new DetalhesPetshop(petshop));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        petshopRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}

