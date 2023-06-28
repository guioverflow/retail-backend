package com.atacadista.response;

import com.atacadista.bean.EstoqueBean;

public record EstoqueResponseDTO(EstabelecimentoResponseDTO estabelecimento, ProdutoResponseDTO produto, Integer quantidade) {
    public EstoqueResponseDTO(EstoqueBean estoque) {
        this(
                new EstabelecimentoResponseDTO( estoque.getEstabelecimento() ),
                new ProdutoResponseDTO( estoque.getProduto() ),
                estoque.getQuantidade()
        );
    }
}
