package br.com.petcare.model.petshop;

import br.com.petcare.dto.petshop.AtualizacaoPetshop;
import br.com.petcare.dto.petshop.CadastroPetshop;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor

@Entity
@Table(name = "TB_PETSHOP")
@EntityListeners(AuditingEntityListener.class)
public class Petshop {

    @Id
    @GeneratedValue
    @Column(name = "CD_MERCADO")
    private Long codigo;

    @Column(name = "NM_MERCADO", nullable = false, length = 100)
    private String nome;

    @Column(name = "NR_CEP", length = 8)
    private String cep;

    @Column(name = "DS_PROMO", nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    private DataPromocao promo; //Informa o dia em que há promoções

    @Column(name = "DT_ABERTURA", nullable = false)
    @Temporal(value=TemporalType.TIME)
    private LocalTime horarioAbertura;

    @Column(name = "DT_FECHAMENTO", nullable = false)
    @Temporal(value=TemporalType.TIME)
    private LocalTime horarioFechamento;

    @Column(name = "BOOL_ESTACIONAMENTO", nullable = false)
    private Boolean possuiEstacionamento; //Informa se o mercado possui estacionamento para os clientes@

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

