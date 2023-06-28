package com.atacadista.test;

import com.atacadista.bean.ProdutoBean;
import com.atacadista.database.PostgreConnection;
import com.atacadista.model.ProdutoModel;

import java.sql.SQLException;
import java.util.List;


public class Produto {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        PostgreConnection postgreConn = new PostgreConnection();

        ProdutoModel model = new ProdutoModel();

        // Teste Select By Id
        ProdutoBean bean = (ProdutoBean) model.selectById(2);
        System.out.println(bean.getNome());
        System.out.println("--------------");

        // Teste Update
        model.update(1, bean);
        ProdutoBean beanUpdateTest = (ProdutoBean) model.selectById(1);
        System.out.println(beanUpdateTest.getNome());
        System.out.println("--------------");

        // Teste Select By Id - Não existente
        ProdutoBean beanIdNotExist = (ProdutoBean) model.selectById(4);
        if (beanIdNotExist != null)
            System.out.println(beanIdNotExist.getNome());
        else
            System.out.println("Não existe esse registro");
        System.out.println("--------------");

        // Teste Delete
        ProdutoBean beanDeleteTest = (ProdutoBean) model.delete(11111);
        if (beanDeleteTest != null)
            System.out.println(beanDeleteTest.getNome());
        else
            System.out.println("Não existe esse registro");
        System.out.println("--------------");

        // Teste Insert
        if (beanDeleteTest != null)
            model.insert(beanDeleteTest);
        else
            System.out.println("Não existe esse registro");

        // Teste Select All
        List<ProdutoBean> testList = model.selectAll();
        for (ProdutoBean beanElement : testList) {
            System.out.println(beanElement.getNome());
        } System.out.println("--------------");


    }
}
