package bean;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FuncionarioBean {
    public int idFuncionario;
    public EstabelecimentoBean estabelecimento;
    public String nome;
    public String cpf;
}
