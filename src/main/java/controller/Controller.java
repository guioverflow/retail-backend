package controller;

import bean.MedicosBean;
import database.PostgreConnection;
import model.Model;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class Controller {
    protected Model model;
    protected PostgreConnection conn;

    public Controller(PostgreConnection conn) {
        this.conn = conn;
    }

    public MedicosBean select(int id) throws SQLException {
        MedicosBean bean = (MedicosBean) this.model.select(id);
        return bean;
    }
}
