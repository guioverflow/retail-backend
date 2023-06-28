package com.atacadista.bean;

import com.atacadista.request.FornecedorRequestDTO;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "fornecedores", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idFornecedor")
public class FornecedorBean {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idFornecedor;
    public String nome;
    public String cnpj;
    public String telefone;
    public String email;

    public FornecedorBean(FornecedorRequestDTO data) {
        this.nome = data.nome();
        this.cnpj = data.cnpj();
        this.telefone = data.telefone();
        this.email = data.email();
    }
}
