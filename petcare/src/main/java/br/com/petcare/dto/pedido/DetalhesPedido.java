package br.com.petcare.dto.pedido;

import br.com.petcare.model.pedido.Pedido;
import br.com.petcare.model.pedido.TipoStatus;

import java.time.LocalDate;

public record DetalhesPedido(Long id, TipoStatus status, Integer total, LocalDate dataPedido) {

    public DetalhesPedido(Pedido pedido){
        this(pedido.getCodigo(), pedido.getStatus(), pedido.getTotal(), pedido.getDataPedido());
    }
}
