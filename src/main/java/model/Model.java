package model;


import bean.ProdutoBean;
import database.PostgreConnection;

import java.sql.SQLException;
import java.util.List;

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
