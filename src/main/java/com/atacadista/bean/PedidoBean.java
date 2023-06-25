package com.atacadista.bean;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class PedidoBean {
    public int idPedido;
    public Date dataPedido;
    public FornecedorBean fornecedor;
    public EstabelecimentoBean estabelecimento;
    public FuncionarioBean funcionario;
}
