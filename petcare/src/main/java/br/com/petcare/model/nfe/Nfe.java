package br.com.petcare.model.nfe;

import br.com.petcare.dto.nfe.DetalhesNfe;
import br.com.petcare.dto.nfe.CadastroNfe;
import br.com.petcare.dto.pedido.CadastroPedido;
import br.com.petcare.model.pedido.Pedido;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter @Setter
@NoArgsConstructor

@Entity
@Table(name = "TB_NFE")
@EntityListeners(AuditingEntityListener.class)
public class Nfe {

    @Id
    @GeneratedValue
    @Column(name = "CD_NFE")
    private Long codigo;

    @Column(name = "NR_CNPJ", length = 14, nullable = false)
    private String cnpj;

    @Column(name = "VL_TOTAL", nullable = false)
    private Double valorTotal;

    @Column(name = "QTD_PRODUTOS", nullable = false, precision = 9)
    private Integer quantidade;

    @OneToOne
    @JoinColumn(name = "cd_pedido", nullable = false, unique = true)
    private Pedido pedido;

    public Nfe(CadastroPedido dto){
        cnpj = dto.cnpj();
        valorTotal = dto.valorTotal();
        quantidade = dto.quantidade();
    }

    public Nfe(DetalhesNfe atualizacao){
        if(atualizacao.cnpj() != null){
            cnpj = atualizacao.cnpj();
        }
        if(atualizacao.valorTotal() != null){
            valorTotal = atualizacao.valorTotal();
        }
        if(atualizacao.quantidade() != null){
            quantidade = atualizacao.quantidade();
        }
    }

}
