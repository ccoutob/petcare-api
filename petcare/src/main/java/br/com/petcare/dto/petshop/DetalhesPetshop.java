package br.com.petcare.dto.petshop;

import br.com.petcare.model.pedido.Pedido;
import br.com.petcare.model.pedido.TipoStatus;
import br.com.petcare.model.petshop.DataPromocao;
import br.com.petcare.model.petshop.Petshop;

import java.time.LocalDate;
import java.time.LocalTime;

public record DetalhesPetshop(Long id, String nome, String cep, DataPromocao promo, LocalTime horarioAbertura, LocalTime horarioFechamento, Boolean possuiEstacionamento) {

    public DetalhesPetshop(Petshop pet){
        this(pet.getCodigo(), pet.getNome(), pet.getCep(), pet.getPromo(),
                pet.getHorarioAbertura(), pet.getHorarioFechamento(), pet.getPossuiEstacionamento());
    }
}
