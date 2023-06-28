package com.atacadista.controller;

import java.sql.SQLException;
import java.util.List;

import com.atacadista.bean.ProdutoBean;
import com.atacadista.model.ProdutoModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController extends AbstractController<ProdutoBean> {

    ProdutoModel model = new ProdutoModel();

    @GetMapping
    @Override
    public ResponseEntity<List<ProdutoBean>> getAll() throws SQLException {
        List<ProdutoBean> productList = model.selectAll();

        if (productList != null)
            return new ResponseEntity<>(productList, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @PostMapping
    @Override
    public ResponseEntity<String> insert(@RequestBody ProdutoBean produto) throws SQLException {
        boolean wasInserted = model.insert(produto);
        if (wasInserted)
            return new ResponseEntity<>("Produto inserido com sucesso.", HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<ProdutoBean> selectById(@PathVariable int id) throws SQLException {
        ProdutoBean selectedProduto = model.selectById(id);

        if (selectedProduto != null)
            return new ResponseEntity<>(selectedProduto, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<ProdutoBean> delete(@PathVariable int id) throws SQLException {
        ProdutoBean deletedBean = model.delete(id);
        if (deletedBean != null)
            return new ResponseEntity<>(deletedBean, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<ProdutoBean> update(@PathVariable int id, @RequestBody ProdutoBean produto) throws SQLException {
        ProdutoBean updatedBean = model.update(id, produto);

        if (updatedBean != null)
            return new ResponseEntity<>(updatedBean, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}
