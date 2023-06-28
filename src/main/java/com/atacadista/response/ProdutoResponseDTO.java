package com.atacadista.response;

import com.atacadista.bean.ProdutoBean;

public record ProdutoResponseDTO(Integer idProduto, String nome, String descricao) {
    public ProdutoResponseDTO(ProdutoBean produtoBean) {
        this(
                produtoBean.getIdProduto(),
                produtoBean.getNome(),
                produtoBean.getDescricao()
        );
    }
}
