package br.com.petcare.dto.petshop;

import br.com.petcare.model.petshop.DataPromocao;

import java.time.LocalTime;

public record AtualizacaoPetshop(Long id, String nome, String cep, DataPromocao promo, LocalTime horarioAbertura, LocalTime horarioFechamento, Boolean possuiEstacionamento) {
}
