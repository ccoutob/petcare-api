package br.com.petcare.model.nfe;

import br.com.petcare.dto.nfe.DetalhesNfe;
import br.com.petcare.dto.nfe.CadastroNfe;
import br.com.petcare.model.pedido.Pedido;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor

@Entity
@Table(name = "TB_NFE")
@EntityListeners(AuditingEntityListener.class)
public class Nfe {

    @Id
    @GeneratedValue
    @Column(name = "cd_nfe")
    private Long codigo;

    @Column(name = "nr_cnpj", length = 14, nullable = false)
    private String cnpj;

    @Column(name = "vl_total", nullable = false)
    private Double valorTotal;

    @Column(name = "qtd_produtos", nullable = false)
    private Integer quantidade;

    @OneToOne
    @JoinColumn(name = "cd_pedido", nullable = false, unique = true)
    private Pedido pedido;

    public Nfe(CadastroNfe cadastro){
        cnpj = cadastro.cnpj();
        valorTotal = cadastro.valorTotal();
        quantidade = cadastro.quantidade();
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
