package bean;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EstabelecimentoBean {
    public int idEstabelecimento;
    public String telefone;
    public String cnpj;
}
