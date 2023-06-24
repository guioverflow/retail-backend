package model;

import bean.MedicosBean;
import database.PostgreConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MedicosModel extends Model {

    public MedicosModel(PostgreConnection conn) {
        super(conn);
    }

    @Override
    public void insert(Object obj) {

    }

    @Override
    public void update(Object obj) {

    }

    @Override
    public void delete(Object obj) {

    }

    @Override
    public MedicosBean selectById(int id) throws SQLException {
        PreparedStatement statement;

        statement = conn.getConnection().prepareStatement("""
            SELECT codm, nome, idade
            FROM public.medicos
            WHERE codm = ?
        """);

        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();
        result.next();

        return MedicosBean
                .builder()
                .codm(result.getInt("codm"))
                .nome(result.getString("nome"))
                .idade(result.getInt("idade"))
                .build();
    }
}
