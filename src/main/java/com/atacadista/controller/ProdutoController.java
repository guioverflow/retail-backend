package com.atacadista.controller;

import java.sql.SQLException;
import java.util.List;

import com.atacadista.bean.ProdutoBean;
import com.atacadista.database.PostgreConnection;
import com.atacadista.model.ProdutoModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produto")
public class ProdutoController extends AbstractController {
    PostgreConnection postConn = new PostgreConnection();
    ProdutoModel model = new ProdutoModel(postConn);

    public ProdutoController() throws SQLException, ClassNotFoundException {

    }

    @GetMapping
    public List<ProdutoBean> getAll() throws SQLException {
        return model.selectAll();
    }

    @Override
    public void insert() throws SQLException {

    }

    @Override
    public void delete() throws SQLException {

    }

    @Override
    public void update() throws SQLException {

    }
}
