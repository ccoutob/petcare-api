package br.com.petcare.dto.nfe;

import br.com.petcare.model.nfe.Nfe;

public record DetalhesNfe(Long codigo,
                          String cnpj,
                          Double valorTotal,
                          Integer quantidade) {

    public DetalhesNfe(Nfe nfe){
        this(nfe.getCodigo(), nfe.getCnpj(),
        nfe.getValorTotal(), nfe.getQuantidade());
    }
}
