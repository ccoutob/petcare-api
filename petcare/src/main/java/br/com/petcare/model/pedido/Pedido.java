package br.com.petcare.model.pedido;

import br.com.petcare.dto.pedido.AtualizacaoPedido;
import br.com.petcare.dto.pedido.CadastroPedido;
import br.com.petcare.model.nfe.Nfe;
import br.com.petcare.model.petshop.Petshop;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor

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

    @Column(name = "DT_PEDIDO", nullable = false)
    private LocalDate dataPedido;

    @OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
    private Nfe nfe;

    @ManyToOne
    @JoinColumn(name = "CD_PETSHOP")
    private Petshop petshop;

    public Pedido(CadastroPedido dto){
        status = dto.status();
        dataPedido = dto.dataPedido();
        nfe = new Nfe(dto);
        nfe.setPedido(this);
    }
    public void atualizar(AtualizacaoPedido auto){
        if(auto.status() != null){
            this.status = auto.status();
        }
        if (auto.valorTotal() != null){
            this.nfe.setValorTotal(auto.valorTotal());
        }
        if (auto.quantidade() != null){
            this.nfe.setQuantidade(auto.quantidade());
        }
    }
}
