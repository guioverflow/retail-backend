package bean;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DescritivoVendaBean {
    public int idVendaProduto;
    public VendaBean venda;
    public ProdutoBean produto;
    public int quantidade;
    public float valorUnitario;
}
