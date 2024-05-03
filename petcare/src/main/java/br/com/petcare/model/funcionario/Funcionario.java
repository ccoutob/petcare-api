package br.com.petcare.model.funcionario;


import br.com.petcare.dto.funcionario.AtualizacaoFuncionario;
import br.com.petcare.dto.funcionario.CadastroFuncionario;
import br.com.petcare.model.petshop.Petshop;
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
@Table(name = "TB_FUNCIONARIO")
@EntityListeners(AuditingEntityListener.class)
public class Funcionario {

    @Id
    @GeneratedValue
    @Column(name = "CD_FUNCIONARIO")
    private Long codigo;

    @Column(name = "NM_FUNCIONARIO", nullable = false, length = 100)
    private String nome;

    @Column(name = "DS_CARGO", nullable = false, length = 25)
    @Enumerated(EnumType.STRING)
    private TipoCargo cargo;

    @Column(name = "DT_ADMISSAO", nullable = false)
    private LocalDate dataAdmissao;

    @ManyToOne
    @JoinColumn(name = "CD_PETSHOP", nullable = false)
    private Petshop petshop;

    public Funcionario(CadastroFuncionario funcionario){
        nome = funcionario.nome();
        cargo = funcionario.cargo();
        dataAdmissao = funcionario.dataAdmissao();
    }

    public Funcionario(CadastroFuncionario funcionario, Petshop petshop){
        nome = funcionario.nome();
        cargo = funcionario.cargo();
        dataAdmissao = funcionario.dataAdmissao();
        this.petshop = petshop;
    }

    public void atualizarDados(AtualizacaoFuncionario atualizacao){
        if(atualizacao.nome() != null)
            nome = atualizacao.nome();
        if(atualizacao.cargo() != null)
            cargo = atualizacao.cargo();
        if(atualizacao.dataAdmissao() != null)
            dataAdmissao = atualizacao.dataAdmissao();
    }
}
