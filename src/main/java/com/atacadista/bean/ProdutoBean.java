package com.atacadista.bean;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProdutoBean {
    public int idProduto;
    public String nome;
    public String descricao;
}
