package com.atacadista.repository;

import com.atacadista.bean.EstoqueBean;
import com.atacadista.bean.FornecedorBean;
import com.atacadista.serializable.EstoqueId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends JpaRepository<EstoqueBean, EstoqueId> {
}
