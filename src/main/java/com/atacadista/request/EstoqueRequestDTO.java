package com.atacadista.request;

public record EstoqueRequestDTO(EstabelecimentoRequestDTO estabelecimento, ProdutoRequestDTO produto, Integer quantidade) {
}
