package com.atacadista.model;


import com.atacadista.database.PostgreConnection;

import java.sql.SQLException;

public abstract class Model {

    protected final PostgreConnection postConn;

    public Model(PostgreConnection conn) {
        this.postConn = conn;
    }

    public abstract boolean insert (Object obj) throws SQLException;
    public abstract Object delete (int id) throws SQLException;
    public abstract Object update (int id, Object obj) throws SQLException;

    public abstract Object selectById (int id) throws SQLException;
    //public abstract List<Object> selectAll () throws SQLException;
}
