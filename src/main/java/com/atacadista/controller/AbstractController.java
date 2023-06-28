package com.atacadista.controller;

import com.atacadista.model.AbstractModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.SQLException;
import java.util.List;

public abstract class AbstractController<beanType> {
    protected AbstractModel<beanType> model;

    public abstract ResponseEntity<String> insert(@RequestBody beanType bean) throws SQLException;

    public abstract ResponseEntity<beanType> delete(@PathVariable int id) throws SQLException;
    public abstract ResponseEntity<beanType> update(@PathVariable int id, @RequestBody beanType produto) throws SQLException;

    public abstract ResponseEntity<beanType> selectById(int id) throws SQLException;
    public abstract ResponseEntity<List<beanType>> getAll() throws SQLException;
}
