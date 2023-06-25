package com.atacadista.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreConnection {

    private final Connection conn;

    public PostgreConnection () throws ClassNotFoundException, SQLException {
        final String jdbcUrl = "jdbc:postgresql://localhost:5432/db_atacadista";
        final String driver = "org.postgresql.Driver";
        final String user = "postgres";
        final String password = "123";

        Class.forName(driver);
        this.conn = DriverManager.getConnection(jdbcUrl, user, password);
    }

    public Connection getConnection() {
        return this.conn;
    }

    public void closeConnection() throws SQLException {
        this.conn.close();
    }
}