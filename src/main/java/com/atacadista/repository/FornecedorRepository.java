package com.atacadista.repository;

import com.atacadista.bean.FornecedorBean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository<FornecedorBean, Integer> {
}
