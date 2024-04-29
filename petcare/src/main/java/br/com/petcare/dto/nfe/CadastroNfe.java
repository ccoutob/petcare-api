package br.com.petcare.dto.nfe;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CadastroNfe(@NotBlank @Size(max = 14)
                          String cnpj,
                          Double valorTotal,
                          Integer quantidade) {
}
