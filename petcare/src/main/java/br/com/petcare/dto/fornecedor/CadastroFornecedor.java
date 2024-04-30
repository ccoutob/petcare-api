package br.com.petcare.dto.fornecedor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CadastroFornecedor(@NotBlank @Size(max= 100)
                                 String nome,
                                 @Size(max= 50)
                                 String email,
                                 @Size(max= 12)
                                 String telefone) {
}
