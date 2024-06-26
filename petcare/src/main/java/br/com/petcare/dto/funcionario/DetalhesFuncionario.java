package br.com.petcare.dto.funcionario;

import br.com.petcare.dto.petshop.DetalhesPetshop;
import br.com.petcare.model.funcionario.Funcionario;
import br.com.petcare.model.funcionario.TipoCargo;

import java.time.LocalDate;

public record DetalhesFuncionario(Long id, String nome, TipoCargo cargo,
                                  LocalDate dataAdmissao, DetalhesPetshop petshop) {

    public DetalhesFuncionario(Funcionario funcionario){
        this(funcionario.getCodigo(), funcionario.getNome(), funcionario.getCargo(),
                funcionario.getDataAdmissao(), new DetalhesPetshop(funcionario.getPetshop()));
    }
}

