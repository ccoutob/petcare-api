package br.com.petcare.model.cliente;

import br.com.petcare.dto.cliente.AtualizacaoCliente;
import br.com.petcare.dto.cliente.CadastroCliente;
import br.com.petcare.model.petshop.Petshop;
import br.com.petcare.model.produto.Produto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "TB_CLIENTE")
@EntityListeners(AuditingEntityListener.class)
public class Cliente {

    @Id
    @GeneratedValue
    @Column(name = "CD_CLIENTE")
    private Long codigo;

    @Column(name = "NM_CLIENTE", length = 100, nullable = false)
    private String nome;

    @Column(name = "NR_TELEFONE", length = 12, unique = true)
    private String telefone;

    @Column(name = "DS_EMAIL", length = 50)
    private String email;

    @ManyToMany
    @JoinTable(name="TB_PRODUTO_CLIENTE",
            joinColumns = @JoinColumn(name="CD_CLIENTE"),
            inverseJoinColumns = @JoinColumn(name="CD_PRODUTO"))
    private List<Produto> produtos;

    @ManyToOne
    @JoinColumn(name = "CD_PETSHOP", nullable = false)
    private Petshop petshop;

    public Cliente(CadastroCliente cliente){
        nome = cliente.nome();
        telefone = cliente.telefone();
        email = cliente.email();
    }

    public Cliente(CadastroCliente cliente, Petshop petshop){
        nome = cliente.nome();
        telefone = cliente.telefone();
        email = cliente.email();
        this.petshop = petshop;
    }

    public void atualizarDados(AtualizacaoCliente atualizacao){
        if(atualizacao.nome() != null)
            nome = atualizacao.nome();
        if(atualizacao.telefone() != null)
            telefone = atualizacao.telefone();
        if(atualizacao.email() != null)
            email = atualizacao.email();
    }
}
