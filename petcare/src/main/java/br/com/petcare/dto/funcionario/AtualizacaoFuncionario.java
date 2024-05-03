package br.com.petcare.dto.funcionario;

import br.com.petcare.model.funcionario.TipoCargo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record AtualizacaoFuncionario(Long id,
                                     @NotBlank @Size(max = 100)
                                     String nome,
                                     @NotNull
                                     TipoCargo cargo,
                                     @NotNull
                                     LocalDate dataAdmissao) {
}