package com.atacadista.bean;

import com.atacadista.request.FornecedorRequestDTO;
import com.atacadista.request.ProdutoRequestDTO;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "produtos", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idProduto")
public class ProdutoBean {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idProduto;
    public String nome;
    public String descricao;

    public ProdutoBean(ProdutoRequestDTO data) {
        this.nome = data.nome();
        this.descricao = data.descricao();
    }
}
