package com.atacadista.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public abstract class AbstractController<requestType, responseType> {

    // CREATE
    public abstract void insert(@RequestBody requestType data);

    // READ
    public abstract List<responseType> selectAll();
    public abstract responseType selectById(@PathVariable int id);

    // UPDATE
    public abstract responseType update(@PathVariable int id, @RequestBody requestType requestDTO);

    // DELETE
    public abstract void deleteById(@PathVariable int id);
}
