package br.com.petcare.dto.pedido;

import br.com.petcare.model.pedido.TipoStatus;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record AtualizacaoPedido(@Size(max = 14)
                                TipoStatus status,
                                @Size(max = 14)
                                String cnpj,
                                Double valorTotal,
                                Integer quantidade) {
}
