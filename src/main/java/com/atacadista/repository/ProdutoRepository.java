package com.atacadista.repository;

import com.atacadista.bean.FornecedorBean;
import com.atacadista.bean.ProdutoBean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoBean, Integer> {
}
