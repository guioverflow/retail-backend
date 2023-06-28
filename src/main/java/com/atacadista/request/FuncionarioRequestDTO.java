package com.atacadista.request;

public record FuncionarioRequestDTO(EstabelecimentoRequestDTO estabelecimento, String nome, String cpf) {
}
