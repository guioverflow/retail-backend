package bean;

// POJO -> Plain Old Java Object, representa uma entidade
// Bean -> Um tipo de POJO, mas com algumas restrições

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MedicosBean {
    public int codm;
    public String nome;
    public int idade;
}
