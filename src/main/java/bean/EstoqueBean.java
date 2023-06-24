package bean;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EstoqueBean {
    public EstabelecimentoBean estabelecimento;
    public ProdutoBean produto;
    public int quantidade;
}
