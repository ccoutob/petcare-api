package br.com.petcare.model.petshop;

import br.com.petcare.dto.petshop.AtualizacaoPetshop;
import br.com.petcare.dto.petshop.CadastroPetshop;
import br.com.petcare.model.cliente.Cliente;
import br.com.petcare.model.fornecedor.Fornecedor;
import br.com.petcare.model.funcionario.Funcionario;
import br.com.petcare.model.pedido.Pedido;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalTime;
import java.util.List;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor

@Entity
@Table(name = "TB_PETSHOP")
@EntityListeners(AuditingEntityListener.class)
public class Petshop {

    @Id
    @GeneratedValue
    @Column(name = "CD_PETSHOP")
    private Long codigo;

    @Column(name = "NM_PETSHOP", nullable = false, length = 100)
    private String nome;

    @Column(name = "NR_CEP", length = 8, nullable = false)
    private String cep;

    @Column(name = "DS_PROMO", nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    private DataPromocao promo; //Informa o dia em que há promoções

    @Column(name = "DT_ABERTURA")
    @Temporal(value=TemporalType.TIME)
    private LocalTime horarioAbertura;

    @Column(name = "DT_FECHAMENTO")
    @Temporal(value=TemporalType.TIME)
    private LocalTime horarioFechamento;

    @Column(name = "BOOL_ESTACIONAMENTO")
    private Boolean possuiEstacionamento; //Informa se o mercado possui estacionamento para os clientes@

    @OneToMany(mappedBy = "petshop")
    private List<Fornecedor> fornecedores;

    @OneToMany(mappedBy = "petshop")
    private List<Pedido> pedidos;

    @OneToMany(mappedBy = "petshop")
    private List<Cliente> clientes;

    @OneToMany(mappedBy = "petshop")
    private List<Funcionario> funcionarios;

    public Petshop(CadastroPetshop pet){
        nome = pet.nome();
        cep = pet.cep();
        promo = pet.promo();
        horarioAbertura = pet.horarioAbertura();
        horarioFechamento = pet.horarioFechamento();
        possuiEstacionamento = pet.possuiEstacionamento();
    }

    public void atualizarDados(AtualizacaoPetshop atualizacao){
        if(atualizacao.nome() != null)
            nome = atualizacao.nome();
        if(atualizacao.cep() != null)
            cep = atualizacao.cep();
        if(atualizacao.promo() != null)
            promo = atualizacao.promo();
        if(atualizacao.horarioAbertura() != null)
            horarioAbertura = atualizacao.horarioAbertura();
        if(atualizacao.horarioFechamento() != null)
            horarioFechamento = atualizacao.horarioFechamento();
        if(atualizacao.possuiEstacionamento() != null)
            possuiEstacionamento = atualizacao.possuiEstacionamento();
    }

}

