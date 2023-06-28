package com.atacadista.repository;

import com.atacadista.bean.EstabelecimentoBean;
import com.atacadista.bean.FornecedorBean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstabelecimentoRepository extends JpaRepository<EstabelecimentoBean, Integer> {
}
