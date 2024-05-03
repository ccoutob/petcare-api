package br.com.petcare.model.fornecedor;

import br.com.petcare.dto.fornecedor.AtualizacaoFornecedor;
import br.com.petcare.dto.fornecedor.CadastroFornecedor;
import br.com.petcare.model.petshop.Petshop;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "TB_FORNECEDOR")
@EntityListeners(AuditingEntityListener.class)
public class Fornecedor {

    @Id
    @GeneratedValue
    @Column(name = "CD_FORNECEDOR")
    private Long codigo;

    @Column(name = "NM_FORNECEDOR", nullable = false, length = 100)
    private String nome;

    @Column(name = "DS_EMAIL", length = 50, nullable = false)
    private String email;

    @Column(name = "NR_TELEFONE", length = 12, nullable = false)
    private String telefone;

    @ManyToOne
    @JoinColumn(name = "CD_PETSHOP", nullable = false)
    private Petshop petshop;

    public Fornecedor(CadastroFornecedor fornecedor){
        nome = fornecedor.nome();
        email = fornecedor.email();
        telefone = fornecedor.telefone();
    }

    public Fornecedor(CadastroFornecedor dto, Petshop petshop){
        nome = dto.nome();
        email = dto.email();
        telefone = dto.telefone();
        this.petshop = petshop;
    }

    public void atualizarDados(AtualizacaoFornecedor atualizacao){
        if(atualizacao.nome() != null)
            nome = atualizacao.nome();
        if(atualizacao.email() != null)
            email = atualizacao.email();
        if(atualizacao.telefone() != null)
            telefone = atualizacao.telefone();
    }
}
