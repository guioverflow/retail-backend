package controller;

import bean.MedicosBean;
import database.PostgreConnection;
import model.Model;

import java.sql.SQLException;

public abstract class Controller {
    protected Model model;

    public Object select(int id) throws SQLException {
        return this.model.select(id);
    }
}
