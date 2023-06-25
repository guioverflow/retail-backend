package com.atacadista.bean;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DescritivoPedidoBean {
    public int idPedidoProduto;
    public PedidoBean pedido;
    public ProdutoBean produto;
    public int quantidade;
    public float valorUnitario;
}
