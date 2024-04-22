package br.com.petcare.dto.nfe;

public record CadastroNfe(Long codigo,
                          String cnpj,
                          Double valorTotal,
                          Integer quantidade) {
}
