package com.atacadista.bean;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class VendaBean {
    public int idVenda;
    public Date dataVenda;
    public EstabelecimentoBean estabelecimento;
    public FuncionarioBean funcionario;
}
