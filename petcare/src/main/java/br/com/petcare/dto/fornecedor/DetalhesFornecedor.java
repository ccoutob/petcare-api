package br.com.petcare.dto.fornecedor;

import br.com.petcare.dto.petshop.DetalhesPetshop;
import br.com.petcare.model.fornecedor.Fornecedor;

public record DetalhesFornecedor(Long id, String nome, String email, String telefone,
                                 DetalhesPetshop petshop) {

    public DetalhesFornecedor(Fornecedor fornecedor){
        this(fornecedor.getCodigo(), fornecedor.getNome(), fornecedor.getEmail(),
                fornecedor.getTelefone(), new DetalhesPetshop(fornecedor.getPetshop()));
    }
}
