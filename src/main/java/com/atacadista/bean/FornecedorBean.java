package com.atacadista.bean;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FornecedorBean {
    public int idFornecedor;
    public String nome;
    public String cnpj;
    public String telefone;
    public String email;
}
