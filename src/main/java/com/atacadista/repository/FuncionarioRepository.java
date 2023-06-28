package com.atacadista.repository;

import com.atacadista.bean.FornecedorBean;
import com.atacadista.bean.FuncionarioBean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<FuncionarioBean, Integer> {
}
