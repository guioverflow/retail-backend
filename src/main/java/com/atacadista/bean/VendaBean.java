package com.atacadista.bean;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class VendaBean {
    public int idVenda;
    public LocalDateTime dataVenda;
    public EstabelecimentoBean estabelecimento;
    public FuncionarioBean funcionario;
}
