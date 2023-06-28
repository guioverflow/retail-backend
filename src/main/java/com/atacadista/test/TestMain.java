package com.atacadista.test;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class TestMain {
    public static void main(String[] args) {
    }

    @GetMapping
    public List<String> routes() {
        return List.of("teste", "produto");
    }
}
