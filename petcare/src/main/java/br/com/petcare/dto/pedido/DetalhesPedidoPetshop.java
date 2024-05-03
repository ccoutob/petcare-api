package br.com.petcare.dto.pedido;

import br.com.petcare.dto.petshop.DetalhesPetshop;
import br.com.petcare.model.pedido.Pedido;
import br.com.petcare.model.pedido.TipoStatus;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

public record DetalhesPedidoPetshop(TipoStatus status, LocalDate dataPedido, DetalhesPetshop petshop) {

    public DetalhesPedidoPetshop(Pedido pedido){
        this(pedido.getStatus(), pedido.getDataPedido(), new DetalhesPetshop(pedido.getPetshop()));
    }


}
