package model;

import bean.MedicosBean;
import bean.ProdutoBean;
import database.PostgreConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MedicosModel extends Model {

    public MedicosModel(PostgreConnection conn) {
        super(conn);
    }

    @Override
    public boolean insert(Object obj) {
        return false;
    }

    @Override
    public Object update(int id, Object obj) {
        return null;
    }

    @Override
    public Object delete(int id) {

        return null;
    }

    @Override
    public MedicosBean selectById(int id) throws SQLException {
        PreparedStatement statement;

        statement = postConn.getConnection().prepareStatement("""
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
