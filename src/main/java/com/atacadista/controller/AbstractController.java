package com.atacadista.controller;

import com.atacadista.database.PostgreConnection;
import com.atacadista.model.Model;

import java.sql.SQLException;

public abstract class AbstractController {
    protected PostgreConnection postConn;
    protected Model model;

    public abstract void insert() throws SQLException;
    public abstract void delete() throws SQLException;
    public abstract void update() throws SQLException;

    public Object selectById(int id) throws SQLException {
        return this.model.selectById(id);
    }
}
