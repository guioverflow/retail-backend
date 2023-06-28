package com.atacadista.model;

import com.atacadista.bean.ProdutoBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoModel extends AbstractModel<ProdutoBean> {

    @Override
    public boolean insert(ProdutoBean produto) throws SQLException {
        PreparedStatement statement;

        if (produto == null)
            return false;

        statement = postConn.getConnection().prepareStatement("""
            INSERT INTO public.produtos (nome, descricao)
            VALUES (?, ?)
        """);

        statement.setString(1, produto.getNome());
        statement.setString(2, produto.getDescricao());

        int linhasAtualizadas = statement.executeUpdate();

        return linhasAtualizadas >= 1;
    }

    @Override
    public ProdutoBean delete(int id) throws SQLException {
        PreparedStatement statement;
        ProdutoBean beanAnterior = selectById(id);

        if (beanAnterior == null)
            return null;

        statement = postConn.getConnection().prepareStatement("""
            DELETE FROM public.produtos
            WHERE id_produto = ?
        """);

        statement.setInt(1, id);
        int linhasAtualizadas = statement.executeUpdate();

        if (linhasAtualizadas < 1)
            return null;

        return beanAnterior;
    }

    @Override
    public ProdutoBean update(int id, ProdutoBean produto) throws SQLException {
        PreparedStatement statement;
        ProdutoBean beanAnterior = selectById(id);

        if (beanAnterior == null)
            return null;

        statement = postConn.getConnection().prepareStatement("""
            UPDATE public.produtos
            SET
                nome = ?,
                descricao = ?
            WHERE id_produto = ?
        """);

        statement.setString(1, produto.getNome());
        statement.setString(2, produto.getDescricao());
        statement.setInt(3, id);

        int linhasAtualizadas = statement.executeUpdate();

        if (linhasAtualizadas < 1)
            return null;

        return beanAnterior;
    }

    @Override
    public ProdutoBean selectById(int id) throws SQLException {
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

    @Override
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
