package com.atacadista.bean;


import com.atacadista.request.EstabelecimentoRequestDTO;
import com.atacadista.request.FornecedorRequestDTO;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "estabelecimentos", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idEstabelecimento")
public class EstabelecimentoBean {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idEstabelecimento;
    public String telefone;
    public String cnpj;

    public EstabelecimentoBean(EstabelecimentoRequestDTO data) {
        this.telefone = data.telefone();
        this.cnpj = data.cnpj();
    }
}
