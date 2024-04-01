package br.com.petcare.model.pedido;

import br.com.petcare.dto.pedido.AtualizacaoPedido;
import br.com.petcare.dto.pedido.CadastroPedido;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "TB_PEDIDO")
@EntityListeners(AuditingEntityListener.class)
public class Pedido {

    @Id
    @GeneratedValue
    @Column(name = "CD_PEDIDO")
    private Long codigo;

    @Column(name = "DS_STATUS_PEDIDO", nullable = false, length = 15)
    @Enumerated(EnumType.STRING)
    private TipoStatus status;

    @Column(name = "NR_TOTAL", nullable = false)
    private Integer total;

    @Column(name = "DT_PEDIDO", nullable = false)
    private LocalDate dataPedido;


    public Pedido(CadastroPedido pedido){
        status = pedido.status();
        total = pedido.total();
        dataPedido = pedido.dataPedido();
    }

    public void atualizarDados(AtualizacaoPedido atualizacao){
        if(atualizacao.status() != null)
            status = atualizacao.status();
        if(atualizacao.total() != null)
            total = atualizacao.total();
        if(atualizacao.dataPedido() != null)
            dataPedido = atualizacao.dataPedido();
    }

}
