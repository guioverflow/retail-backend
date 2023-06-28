package com.atacadista.bean;

import com.atacadista.request.EstoqueRequestDTO;
import com.atacadista.serializable.EstoqueId;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "estabelecimentos_produtos", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
public class EstoqueBean {

    @EmbeddedId
    EstoqueId id;

    @MapsId("idEstabelecimento")
    @ManyToOne
    @JoinColumn(name = "id_estabelecimento")
    public EstabelecimentoBean estabelecimento;

    @MapsId("idProduto")
    @ManyToOne
    @JoinColumn(name = "id_produto")
    public ProdutoBean produto;

    public int quantidade;

    public EstoqueBean(EstoqueRequestDTO data) {
        this.estabelecimento = new EstabelecimentoBean( data.estabelecimento() );
        this.produto = new ProdutoBean( data.produto() );
        this.quantidade = data.quantidade();
    }
}