package br.com.petcare.dto.pedido;

import br.com.petcare.model.pedido.Pedido;
import br.com.petcare.model.pedido.TipoStatus;

import java.time.LocalDate;

public record DetalhesPedido(Long id, TipoStatus status, LocalDate dataPedido,
                             String cnpj, Double valorTotal, Integer quantidade) {

    public DetalhesPedido(Pedido pedido){
        this(pedido.getCodigo(), pedido.getStatus(), pedido.getDataPedido(),
                pedido.getNfe().getCnpj(), pedido.getNfe().getValorTotal(),
                pedido.getNfe().getQuantidade());
    }

}
