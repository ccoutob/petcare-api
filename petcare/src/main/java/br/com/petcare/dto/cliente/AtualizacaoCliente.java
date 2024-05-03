package br.com.petcare.dto.cliente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AtualizacaoCliente(Long codigo,
                                 @NotBlank @Size(max = 100)
                                 String nome,
                                 @NotBlank @Size(max = 12)
                                 String telefone,
                                 @NotBlank @Size(max = 50)
                                 String email) {
}
