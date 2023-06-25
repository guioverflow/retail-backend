package model;

import bean.ProdutoBean;
import database.PostgreConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoModel extends Model {
    public ProdutoModel(PostgreConnection conn) {
        super(conn);
    }

    @Override
    public boolean insert(Object objBean) throws SQLException {
        PreparedStatement statement;
        ProdutoBean bean = (ProdutoBean) objBean;

        if (bean == null)
            return false;

        statement = postConn.getConnection().prepareStatement("""
            INSERT INTO public.produtos
            VALUES (?, ?)
        """);

        statement.setString(1, bean.getNome());
        statement.setString(2, bean.getDescricao());
        statement.execute();

        return true;
    }

    @Override
    public Object delete(int id) throws SQLException {
        PreparedStatement statement;
        ProdutoBean bean = (ProdutoBean) selectById(id);

        if (bean == null)
            return null;

        statement = postConn.getConnection().prepareStatement("""
            DELETE FROM public.produtos
            WHERE id_produto = ?
        """);

        statement.setInt(1, id);
        statement.execute();

        return bean;
    }

    @Override
    public Object update(int id, Object beanObj) throws SQLException {
        PreparedStatement statement;
        ProdutoBean beanAnterior = (ProdutoBean) selectById(id);

        if (beanAnterior == null)
            return null;

        ProdutoBean bean = (ProdutoBean) beanObj;

        statement = postConn.getConnection().prepareStatement("""
            UPDATE public.produtos
            SET
                nome = ?,
                descricao = ?
            WHERE id_produto = ?
        """);

        statement.setString(1, bean.getNome());
        statement.setString(2, bean.getDescricao());
        statement.setInt(3, id);
        statement.executeUpdate();

        return beanAnterior;
    }

    @Override
    public Object selectById(int id) throws SQLException {
        PreparedStatement statement;

        statement = postConn.getConnection().prepareStatement("""
            SELECT id_produto, nome, descricao
            FROM public.produtos
            WHERE id_produto = ?
        """);

        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();

        if (result.next())
            return ProdutoBean
                    .builder()
                    .idProduto(result.getInt("id_produto"))
                    .nome(result.getString("nome"))
                    .descricao(result.getString("descricao"))
                    .build();
        else
            return null;
    }

    public List<ProdutoBean> selectAll() throws SQLException {
        PreparedStatement statement;

        List<ProdutoBean> productList = new ArrayList<>();

        statement = postConn.getConnection().prepareStatement("""
            SELECT id_produto, nome, descricao
            FROM public.produtos
            ORDER BY id_produto ASC
        """);
        ResultSet result = statement.executeQuery();

        while (result.next()) {
            productList.add(ProdutoBean
                                .builder()
                                .idProduto(result.getInt("id_produto"))
                                .nome(result.getString("nome"))
                                .descricao(result.getString("descricao"))
                                .build()
            );
        }

        return productList;
    }
}
