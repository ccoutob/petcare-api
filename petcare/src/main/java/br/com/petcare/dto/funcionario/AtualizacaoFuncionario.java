package br.com.petcare.dto.funcionario;

import br.com.petcare.model.funcionario.TipoCargo;

import java.time.LocalDate;

public record AtualizacaoFuncionario(Long id, String nome, TipoCargo cargo, LocalDate dataAdmissao) {
}