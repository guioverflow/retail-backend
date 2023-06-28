package com.atacadista.model;


import com.atacadista.database.PostgreConnection;
import java.sql.SQLException;
import java.util.List;

public abstract class AbstractModel<beanType> {

    protected PostgreConnection postConn;

    public AbstractModel() {
        try {
            this.postConn = new PostgreConnection();
        } catch (ClassNotFoundException notFound) {
            notFound.printStackTrace();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public abstract boolean insert (beanType bean) throws SQLException;
    public abstract beanType delete (int id) throws SQLException;
    public abstract beanType update (int id, beanType bean) throws SQLException;

    public abstract beanType selectById (int id) throws SQLException;
    public abstract List<beanType> selectAll () throws SQLException;
}
