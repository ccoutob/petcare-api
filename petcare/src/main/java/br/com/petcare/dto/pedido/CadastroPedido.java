package br.com.petcare.dto.pedido;

import br.com.petcare.model.pedido.TipoStatus;

import java.time.LocalDate;

public record CadastroPedido(Long id, TipoStatus status, Integer total, LocalDate dataPedido) {
}
