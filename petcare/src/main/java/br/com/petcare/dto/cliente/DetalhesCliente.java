package br.com.petcare.dto.cliente;

import br.com.petcare.model.cliente.Cliente;

public record DetalhesCliente(Long codigo, String nome, String telefone, String email) {

    public DetalhesCliente(Cliente cliente){
        this(cliente.getCodigo(), cliente.getNome(), cliente.getTelefone(), cliente.getEmail());
    }
}
