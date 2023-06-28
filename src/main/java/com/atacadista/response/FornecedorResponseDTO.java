package com.atacadista.response;

import com.atacadista.bean.FornecedorBean;

public record FornecedorResponseDTO (Integer id, String nome, String cnpj, String telefone, String email) {
    public FornecedorResponseDTO (FornecedorBean fornecedor) {
        this(
                fornecedor.getIdFornecedor(),
                fornecedor.getNome(),
                fornecedor.getCnpj(),
                fornecedor.getTelefone(),
                fornecedor.getEmail()
        );
    }
}
