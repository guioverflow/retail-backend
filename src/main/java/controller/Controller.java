package controller;

import model.Model;

import java.sql.SQLException;

public abstract class Controller {
    protected Model model;

    public abstract void insert() throws SQLException;
    public abstract void delete() throws SQLException;
    public abstract void update() throws SQLException;

    public Object selectById(int id) throws SQLException {
        return this.model.selectById(id);
    }
}
