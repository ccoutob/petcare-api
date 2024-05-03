package br.com.petcare.dto.cliente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CadastroCliente(@NotBlank @Size(max = 100)
                              String nome,
                              @Size(max = 12)
                              String telefone,
                              @Size(max = 50)
                              String email) {
}
