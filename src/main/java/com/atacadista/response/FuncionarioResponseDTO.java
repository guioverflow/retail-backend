package com.atacadista.response;

import com.atacadista.bean.FornecedorBean;
import com.atacadista.bean.FuncionarioBean;
import com.atacadista.request.EstabelecimentoRequestDTO;

public record FuncionarioResponseDTO(Integer id, EstabelecimentoResponseDTO estabelecimento, String nome, String cpf) {
    public FuncionarioResponseDTO(FuncionarioBean funcionarioBean) {
        this(
                funcionarioBean.getIdFuncionario(),
                new EstabelecimentoResponseDTO( funcionarioBean.getEstabelecimento() ),
                funcionarioBean.getNome(),
                funcionarioBean.getCpf()
        );
    }
}
