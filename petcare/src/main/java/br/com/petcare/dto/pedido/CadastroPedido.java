package br.com.petcare.dto.pedido;

import br.com.petcare.model.pedido.TipoStatus;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record CadastroPedido(@NotNull
                             TipoStatus status,
                             @NotNull
                             LocalDate dataPedido,
                             @NotBlank @Size (max = 14)
                             String cnpj,
                             @NotNull
                             Double valorTotal,
                             @NotNull
                             Integer quantidade) {
}
