package br.com.petcare.model.produto;

import br.com.petcare.model.cliente.Cliente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
    @Table(name = "TB_PRODUTO")
@EntityListeners(AuditingEntityListener.class)
public class Produto {

    @Id
    @GeneratedValue
    @Column(name = "CD_PRODUTO")
    private Long codigo;

    @Column(name = "NM_PRODUTO", nullable = false, length = 100)
    private String nome;

    @Column(name = "TP_PRODUTO", nullable = false, length = 30)
    @Enumerated(EnumType.STRING)
    private TipoProduto tipo;

    @Column(name = "VL_PRODUTO", nullable = false)
    private Double valor;

    @Column(name = "DT_VALIDADE", nullable = false)
    private LocalDate dataValidade;

    @ManyToMany(mappedBy = "produtos")
    private List<Cliente> clientes;
}
