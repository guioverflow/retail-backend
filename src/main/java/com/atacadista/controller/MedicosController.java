package com.atacadista.controller;

import com.atacadista.database.PostgreConnection;
import com.atacadista.model.MedicosModel;
import java.sql.SQLException;

public class MedicosController extends AbstractController {
    public MedicosController(PostgreConnection conn) {
        this.model = new MedicosModel(conn);
    }

    @Override
    public void insert() throws SQLException {
        throw new SQLException(); // Temporário
    }

    @Override
    public void delete() throws SQLException {
        throw new SQLException(); // Temporário
    }

    @Override
    public void update() throws SQLException {
        throw new SQLException(); // Temporário
    }
}

