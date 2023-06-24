package model;


import database.PostgreConnection;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class Model {

    protected final PostgreConnection conn;

    public Model(PostgreConnection conn) {
        this.conn = conn;
    }

    public abstract void insert (Object obj);
    public abstract void delete (Object obj);
    public abstract Object select (int id) throws SQLException;

}
