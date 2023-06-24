package controller;

import bean.MedicosBean;
import database.PostgreConnection;
import model.Model;

import java.sql.SQLException;

public abstract class Controller {
    protected Model model;

    public MedicosBean select(int id) throws SQLException {
        return (MedicosBean) this.model.select(id);
    }
}
