package com.atacadista.response;

import com.atacadista.bean.EstabelecimentoBean;

public record EstabelecimentoResponseDTO(String telefone, String cnpj) {
    public EstabelecimentoResponseDTO(EstabelecimentoBean estabelecimentoBean) {
        this(
                estabelecimentoBean.getTelefone(),
                estabelecimentoBean.getCnpj()
        );
    }
}
