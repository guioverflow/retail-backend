package controller;

import bean.MedicosBean;
import database.PostgreConnection;
import model.MedicosModel;
import model.Model;

import java.sql.Connection;

public class MedicosController extends Controller {
    public MedicosController(PostgreConnection conn) {
        this.model = new MedicosModel(conn);
    }

}

