package br.com.petcare.dto.fornecedor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AtualizacaoFornecedor(Long id,
                                    @NotBlank @Size(max = 100)
                                    String nome,
                                    @NotBlank @Size(max = 50)
                                    String email,
                                    @NotBlank @Size(max = 12)
                                    String telefone) {
}
