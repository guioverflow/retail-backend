package com.atacadista.bean;

import com.atacadista.request.FuncionarioRequestDTO;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "funcionarios", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idFuncionario")
public class FuncionarioBean {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idFuncionario;

    @ManyToOne
    @JoinColumn(name = "idEstabelecimento")
    public EstabelecimentoBean estabelecimento;
    public String nome;
    public String cpf;

    public FuncionarioBean(FuncionarioRequestDTO data) {
        this.estabelecimento = new EstabelecimentoBean( data.estabelecimento() );
        this.nome = data.nome();
        this.cpf = data.cpf();
    }
}
